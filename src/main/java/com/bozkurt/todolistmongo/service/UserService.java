package com.bozkurt.todolistmongo.service;

import com.bozkurt.todolistmongo.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findById(String id);
    User findByEmail(String email);
    List<User> findAll();
}
