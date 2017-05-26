package com.greenfox.peertopeerbynagyza.model;

import com.greenfox.peertopeerbynagyza.model.Message;
import com.greenfox.peertopeerbynagyza.model.P2pClient;
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
