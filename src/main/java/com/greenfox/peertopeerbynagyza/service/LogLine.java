package com.greenfox.peertopeerbynagyza.service;

import java.time.LocalDateTime;

public class LogLine {

  private LocalDateTime date;
  private String logLevel;
  private String endpointPath;
  private String method;
  private String requestData;

  public LogLine(String logLevel, String endpointPath, String method, String requestData) {
    this.date = LocalDateTime.now();
    this.logLevel = logLevel;
    this.endpointPath = endpointPath;
    this.method = method;
    this.requestData = requestData;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate() {
    this.date = LocalDateTime.now();
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getEndpointPath() {
    return endpointPath;
  }

  public void setEndpointPath(String endpointPath) {
    this.endpointPath = endpointPath;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    return date + " " + logLevel + " " + endpointPath +" " + method + " " + requestData;
  }
}
