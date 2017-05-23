package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.service.*;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  ShowLog showLog;

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  ErrorMessage errorMessage;

  @GetMapping("/")
  public String mainPage(Model model) {
    showLog.printLogLine(new LogLine("INFO", "/", "GET", ""));
    if (usersRepository.count() > 0) {
      if (usersRepository.findOne((long) 1).getUsername().isEmpty()) {
        model.addAttribute("message", "The username field is empty");
      }
      model.addAttribute("user", usersRepository.findOne((long) 1));
      model.addAttribute("messagesText", messageRepository.findAllByOrderByTimestampDesc());
      return "index";
    } else {
      return "enter";
    }
  }

  @PostMapping("/enter")
  public String setUser(Model model,@RequestParam("name") String param) {
    if (param.isEmpty()) {
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
  public String changeUserAct(Model model, @ModelAttribute("name") String param) {
    User user = usersRepository.findOne((long) 1);
    user.setUserame(param);
    usersRepository.save(user);
    return "redirect:/";
  }

  @PostMapping("/send_message")
  public String sendMessage(@RequestParam String text, @RequestParam String user) {
    Message message = new Message(user, text);
    boolean idIsNotUnique;
    do {
      idIsNotUnique = false;
      for (Message actual : messageRepository.findAll()) {
        if (actual.getId() == message.getId()) {
          idIsNotUnique = true;
        }
      }
      if (idIsNotUnique) {
        message.setId();
        System.out.println(message.getId());
        System.out.println("HAHAHAHA");
      }
    } while (idIsNotUnique);
    messageRepository.save(message);
    return "redirect:/";
  }

  @ExceptionHandler(Exception.class)
  public ErrorMessage errorMessageSender(MissingServletRequestParameterException e) {
    String paramName = e.getParameterName();
    errorMessage.setError("Hello! Something wrong with the " + paramName + " parameter.");
    return errorMessage;
  }
}
