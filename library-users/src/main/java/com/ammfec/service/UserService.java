package com.ammfec.service;

import com.ammfec.dto.request.UserRequest;
import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;

import java.util.List;

public interface UserService {

    UsersResponse getUsers();

    UserResponse getUser(Integer id);

    UserResponse createUser(UserRequest user);

    UserResponse updateUser(Integer id, UserRequest user);

    void deleteUser(Integer id);
}
