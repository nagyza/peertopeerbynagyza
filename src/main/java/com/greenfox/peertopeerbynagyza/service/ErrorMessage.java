package com.greenfox.peertopeerbynagyza.service;

import org.springframework.stereotype.Service;

@Service
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
