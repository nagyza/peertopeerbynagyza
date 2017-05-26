package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.model.ErrorMessage;
import com.greenfox.peertopeerbynagyza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  private static final String CHAT_APP_UNIQUE_ID = "https://p2p-by-nagyza.herokuapp.com/";

  @Autowired
  ErrorMessage errorMessage;

  @Autowired
  MainService mainService;

  @GetMapping("/")
  public String mainPage(Model model) {
    return mainService.indexSiteCreator(model);
  }

  @PostMapping("/enter")
  public String setUser(Model model,@RequestParam("name") String param) {
    return mainService.enterSiteCreator(model, param);
  }

  @GetMapping("/update_user")
  public String updateUser(Model model, @ModelAttribute("name") String param) {
    return mainService.updateUser(model, param);
  }

  @PostMapping("/send_message")
  public String sendMessage(@RequestParam String text, @RequestParam String user) {
    return mainService.sendMessage(text, user);
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage errorMessageSender(MissingServletRequestParameterException e) {
    System.out.println("Something wrong whit the next parameter(s)" + e.getParameterName());
    return errorMessage;
  }
}
