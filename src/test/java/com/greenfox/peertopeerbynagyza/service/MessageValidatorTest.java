package com.greenfox.peertopeerbynagyza.service;

import com.greenfox.peertopeerbynagyza.model.Message;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageValidatorTest {

  private MessageValidator messageValidator = new MessageValidator();
  @Test
  public void isMessageValidAllFieldOk() throws Exception {
    Message message = new Message("nagyza", "hello");
    assertTrue(messageValidator.isMessageValid(message));
  }

  @Test
  public void isMessageValidUserNotOk() throws Exception {
    Message message = new Message("", "hello");
    assertFalse(messageValidator.isMessageValid(message));
  }

  @Test
  public void isMessageValidTextNotOk() throws Exception {
    Message message = new Message("nagyza", "");
    assertFalse(messageValidator.isMessageValid(message));
  }
}