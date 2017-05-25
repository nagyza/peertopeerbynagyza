package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import com.greenfox.peertopeerbynagyza.service.MessageWrapper;
import com.greenfox.peertopeerbynagyza.service.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class P2pRestController {

  private static final String CHAT_APP_UNIQUE_ID = System.getenv("CHAT_APP_UNIQUE_ID");

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  UsersRepository usersRepository;

  @PostMapping(value = "/api/message/receive", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @CrossOrigin("*")
  public ResponseMessage receiveMessage(@RequestBody MessageWrapper messageWrapper) {
    ResponseMessage responseMessage = new  ResponseMessage("ok");
    messageRepository.save(messageWrapper.getMessage());
    if (!messageWrapper.getClient().getId().equals(usersRepository.findOne((long) 1).getUsername())) {
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.postForObject(CHAT_APP_UNIQUE_ID + "/api/message/receive", messageWrapper, ResponseMessage.class);
    }
    return responseMessage;
  }
}
