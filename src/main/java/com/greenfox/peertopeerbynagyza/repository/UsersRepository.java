package com.greenfox.peertopeerbynagyza.repository;

import com.greenfox.peertopeerbynagyza.service.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
