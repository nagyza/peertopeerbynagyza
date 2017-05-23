package com.greenfox.peertopeerbynagyza.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String user;
  private String text;
  private Long timestamp;

  public Message() {
  }

  public Message(String user, String text) {
    this.id = (long) (Math.random() * 8999999) + 1000000;
    this.user = user;
    this.text = text;
    this.timestamp = System.currentTimeMillis();
  }
}
