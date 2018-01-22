package com.bozkurt.todolistmongo.repository;

import com.bozkurt.todolistmongo.model.UserList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserListRepository extends MongoRepository<UserList, String> {

}
