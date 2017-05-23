package com.greenfox.peertopeerbynagyza.service;

import org.springframework.stereotype.Component;

@Component
public class P2pClient {

  private String id;

  public P2pClient() {
  }

  public P2pClient(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
