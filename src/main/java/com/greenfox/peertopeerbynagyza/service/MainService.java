package com.greenfox.peertopeerbynagyza.service;

import com.greenfox.peertopeerbynagyza.model.*;
import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {

  private static final String CHAT_APP_UNIQUE_ID = "https://p2p-by-nagyza.herokuapp.com";

  @Autowired
  ShowLog showLog;

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  MessageWrapper messageWrapper;

  public MainService() {
  }

  public String indexSiteCreator(Model model) {
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

  public String enterSiteCreator(Model model, String param) {
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

  public String updateUser(Model model, String param) {
    User user = usersRepository.findOne((long) 1);
    user.setUserame(param);
    usersRepository.save(user);
    return "redirect:/";
  }

  public String sendMessage(String text, String user) {
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
    messageWrapper.setMessage(message);
    messageWrapper.setClient(new P2pClient(usersRepository.findOne((long) 1).getUsername()));
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(CHAT_APP_UNIQUE_ID + "/api/message/receive", messageWrapper, ResponseMessage.class);
    return "redirect:/";
  }
}
