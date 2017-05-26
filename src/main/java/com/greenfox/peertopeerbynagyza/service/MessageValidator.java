package com.greenfox.peertopeerbynagyza.service;

import org.springframework.stereotype.Service;

@Service
public class MessageValidator {

  public boolean isMessageWrapperValid(MessageWrapper messageWrapper) {
    if (isMessageValid(messageWrapper.getMessage()) && isClientValid(messageWrapper.getClient())) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isMessageValid(Message message) {
    return idOk(message) && textNotEmpty(message.getText()) && timestempNotEmpty(message.getTimestamp()) && usernameNotEmpty(message.getUsername());
  }

  public String getMissingFieldsMessage(MessageWrapper messageWrapper) {
    String errorMessage = "Missing field(s): ";
    int errorMessageBasicLength = errorMessage.length();
    if (!idOk(messageWrapper.getMessage())) {
      errorMessage += "message.id";
    }
    if (!textNotEmpty(messageWrapper.getMessage().getText())) {
      errorMessage = addSeparator(errorMessage, errorMessageBasicLength, errorMessage.length());
      errorMessage += "message.text";
    }
    if (!timestempNotEmpty(messageWrapper.getMessage().getTimestamp())) {
      errorMessage = addSeparator(errorMessage, errorMessageBasicLength, errorMessage.length());
      errorMessage += "message.timestamp";
    }
    if (!usernameNotEmpty(messageWrapper.getMessage().getUsername())) {
      errorMessage = addSeparator(errorMessage, errorMessageBasicLength, errorMessage.length());
      errorMessage += "message.username";
    }
    if (messageWrapper.getClient().getId().isEmpty()) {
      errorMessage = addSeparator(errorMessage, errorMessageBasicLength, errorMessage.length());
      errorMessage += "client.id";
    }
    return errorMessage;
  }

  private String addSeparator(String errorMessage, int basicLength, int actualLength) {
    if (actualLength > basicLength) {
      errorMessage += ", ";
      return errorMessage;
    } else {
      return errorMessage;
    }
  }

  private boolean isClientValid(P2pClient client) {
    return !client.getId().isEmpty();
  }

  private boolean idOk(Message message) {
    if (message.getId() == null || message.getId() < 1) {
      return false;
    } else {
      return true;
    }
  }

  private boolean textNotEmpty(String text) {
    return !text.isEmpty();
  }

  private boolean timestempNotEmpty(Long timestamp) {
    return timestamp != null;
  }

  private boolean usernameNotEmpty(String username) {
    return !username.isEmpty();
  }
}
