package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.repository.MessageRepository;
import com.greenfox.peertopeerbynagyza.service.MessageWrapper;
import com.greenfox.peertopeerbynagyza.service.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class P2pRestController {

  @Autowired
  MessageRepository messageRepository;

  @PostMapping("/api/message/receive")
  @ResponseBody
  @CrossOrigin("*")
  public ResponseMessage receiveMessage(@RequestBody MessageWrapper messageWrapper) {
    ResponseMessage responseMessage = new  ResponseMessage("ok");
    messageRepository.save(messageWrapper.getMessage());
    return responseMessage;
  }
}
