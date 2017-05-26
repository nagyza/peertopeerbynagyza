package com.greenfox.peertopeerbynagyza.repository;

import com.greenfox.peertopeerbynagyza.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
  public Iterable<Message> findAllByOrderByTimestampDesc();
}
