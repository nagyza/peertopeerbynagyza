package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.model.MessageWrapper;
import com.greenfox.peertopeerbynagyza.model.ResponseErrorMessage;
import com.greenfox.peertopeerbynagyza.model.ResponseMessage;
import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.repository.UsersRepository;
import com.greenfox.peertopeerbynagyza.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class P2pRestController {

  private static final String CHAT_APP_UNIQUE_ID = "https://p2p-by-nagyza.herokuapp.com/";

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  UsersRepository usersRepository;

  @Autowired
  MessageValidator messageValidator;

  @PostMapping(value = "/api/message/receive")
  @ResponseBody
  @CrossOrigin("*")
  public ResponseMessage receiveMessage(@RequestBody MessageWrapper messageWrapper) {
    if (messageValidator.isMessageWrapperValid(messageWrapper)) {
      if (!messageWrapper.getClient().getId().equals(usersRepository.findOne((long) 1).getUsername())) {
        messageRepository.save(messageWrapper.getMessage());
        RestTemplate restTemplate = new RestTemplate();
        ResponseErrorMessage responseErrorMessage = restTemplate.postForObject(CHAT_APP_UNIQUE_ID + "/api/message/receive", messageWrapper, ResponseErrorMessage.class);
        System.out.println(responseErrorMessage);
      }
      return new ResponseMessage("ok");
    } else {
      return new ResponseErrorMessage("error", messageValidator.getMissingFieldsMessage(messageWrapper));
    }
  }
}
