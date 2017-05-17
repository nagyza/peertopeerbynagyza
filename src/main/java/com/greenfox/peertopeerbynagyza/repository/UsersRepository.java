package com.greenfox.peertopeerbynagyza.repository;

import com.greenfox.peertopeerbynagyza.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
}
