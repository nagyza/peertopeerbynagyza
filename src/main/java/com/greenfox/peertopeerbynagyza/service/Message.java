package com.greenfox.peertopeerbynagyza.service;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {

  @Id
  private long id;
  private String username;
  private String text;
  private Long timestamp;

  public Message() {
  }

  public Message(String user, String text) {
    setId();
    this.username = user;
    this.text = text;
    this.timestamp = System.currentTimeMillis();
  }

  public long getId() {
    return id;
  }

  public void setId() {
    this.id = (long) (Math.random() * 8999999) + 1000000;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
