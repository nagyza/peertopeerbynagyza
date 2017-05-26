package com.greenfox.peertopeerbynagyza.service;

import com.greenfox.peertopeerbynagyza.model.LogLine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ShowLog {
  private LogLine logLine;

  public ShowLog() {
  }

  public void printLogLine(LogLine logLine) {
    System.out.println(logLine.toString());
  }
}
