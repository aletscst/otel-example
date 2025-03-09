package com.ammfec.service;

import com.ammfec.dto.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    User createUser(User user);

    User updateUser(Integer id, User user);

    void deleteUser(Integer id);
}
