package com.greenfox.peertopeerbynagyza.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name = "messages")
public class Message {

  @Id
  private long id;
  private String user;
  private String text;
  private String date;

  public Message() {
  }

  public Message(String user, String text) {
    this.id = (long) (Math.random() * 8999999) + 1000000;
    this.user = user;
    this.text = text;
    this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.mm.dd hh:MM:ss"));
  }
}
