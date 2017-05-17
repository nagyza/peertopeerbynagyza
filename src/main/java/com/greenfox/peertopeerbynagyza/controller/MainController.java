package com.greenfox.peertopeerbynagyza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String mainPage() {
    System.out.println(System.getenv("CHAT_APP_LOGLEVEL"));
    return "index";
  }


}
