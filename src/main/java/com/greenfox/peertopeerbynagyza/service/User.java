package com.greenfox.peertopeerbynagyza.service;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String username;

  public User() {
  }

  public User(String name) {
    this.username = name;
  }

  public long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUserame(String name) {
    this.username = name;
  }
}
