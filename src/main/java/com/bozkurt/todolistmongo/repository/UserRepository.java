package com.bozkurt.todolistmongo.repository;

import com.bozkurt.todolistmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
