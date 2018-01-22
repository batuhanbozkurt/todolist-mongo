package com.bozkurt.todolistmongo.service;

import com.bozkurt.todolistmongo.model.User;
import com.bozkurt.todolistmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return (List)userRepository.findAll();
    }
}
