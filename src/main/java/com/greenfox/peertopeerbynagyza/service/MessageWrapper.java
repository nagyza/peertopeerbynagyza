package com.greenfox.peertopeerbynagyza.service;

import org.springframework.stereotype.Component;

@Component
public class MessageWrapper {
  private Message message;
  private P2pClient client;

  public MessageWrapper() {
  }

  public MessageWrapper(Message message, P2pClient client) {
    this.message = message;
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public P2pClient getClient() {
    return client;
  }

  public void setClient(P2pClient client) {
    this.client = client;
  }
}
