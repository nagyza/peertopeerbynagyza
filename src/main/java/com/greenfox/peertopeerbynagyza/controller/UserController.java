package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.service.*;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    String paramName = e.getParameterName();
    errorMessage.setError("Hello! Something wrong with the " + paramName + " parameter.");
    return errorMessage;
  }
}
