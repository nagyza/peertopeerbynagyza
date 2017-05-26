package com.greenfox.peertopeerbynagyza.model;

import org.springframework.stereotype.Component;

@Component
public class ResponseErrorMessage extends ResponseMessage {

  private String message;

  public ResponseErrorMessage() {
  }

  public ResponseErrorMessage(String status) {
    super(status);
  }

  public ResponseErrorMessage(String status, String message) {
    super(status);
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    if (message == null) {
      return "status: " + getStatus();
    } else {
      return "status: " + getStatus() + " message: " + message;
    }
  }
}
