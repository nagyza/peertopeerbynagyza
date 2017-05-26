package com.greenfox.peertopeerbynagyza.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessage {
  private String status;

  public ResponseMessage() {
  }

  public ResponseMessage(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
