package com.example.yonseitalk.repository;

import com.example.yonseitalk.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    //create
    User save(User user);

    //read
    Optional<User> findById(String userId);
    List<User> searchUser(String name);

    //update
    void modifyStatusMessage(User user ,String statusMessage);

    //delete
    void deleteUser(User user);
}
