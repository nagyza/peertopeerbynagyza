package com.greenfox.peertopeerbynagyza.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorMessage {
  private String error;

  public ErrorMessage() {
  }

  public ErrorMessage(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
