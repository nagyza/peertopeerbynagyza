package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.model.User;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import com.greenfox.peertopeerbynagyza.service.EnterSite;
import com.sun.javafx.collections.UnmodifiableListSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  EnterSite enterSite;

  @Autowired
  UsersRepository usersRepository;

  @GetMapping("/")
  public String mainPage(Model model) {
    System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
    if (usersRepository.count() > 0) {
      model.addAttribute("user", usersRepository.findOne((long) 1));
      return "index";
    } else {
      return "enter";
    }
  }

  @PostMapping("/enter")
  public String setUser(Model model, @RequestParam("name") String param) {
    usersRepository.save(new User(param));
    return "redirect:/";
  }

}
