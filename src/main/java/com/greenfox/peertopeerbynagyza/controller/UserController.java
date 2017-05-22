package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.service.LogLine;
import com.greenfox.peertopeerbynagyza.service.ShowLog;
import com.greenfox.peertopeerbynagyza.service.User;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  ShowLog showLog;

  @GetMapping("/")
  public String mainPage(Model model) {
    showLog.printLogLine(new LogLine("INFO", "/", "GET", ""));
    if (usersRepository.count() > 0) {
      model.addAttribute("user", usersRepository.findOne((long) 1));
      return "index";
    } else {
      return "enter";
    }
  }

  @PostMapping("/enter")
  public String setUser(Model model,@RequestParam("name") String param) {
    if (param.length() == 0) {
      model.addAttribute("message", "The username field is empty");
      showLog.printLogLine(new LogLine("INFO", "/enter", "POST", "name="));
      return "enter";
    } else {
      showLog.printLogLine(new LogLine("INFO", "/enter", "POST", "name=" + param));
      usersRepository.save(new User(param));
      return "redirect:/";
    }
  }

  @GetMapping("/update_user")
  public String changeUserAct(Model model, @RequestParam("name") String param) {
    if (param.length() == 0) {
      model.addAttribute("message", "The username field is empty");
      return "redirect:/";
    } else {
      changeUser(param);
      return "redirect:/";
    }
  }

  @PutMapping("/updateuser")
  public void changeUser(String param) {
    User user = usersRepository.findOne((long) 1);
    user.setName(param);
    usersRepository.save(user);
    showLog.printLogLine(new LogLine("INFO", "/updateuser", "PUT", "name=" + param));
  }
}