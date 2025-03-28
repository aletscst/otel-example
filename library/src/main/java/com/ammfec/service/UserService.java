package com.ammfec.service;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;

import java.util.List;

public interface UserService {
    UsersResponse getAllUsers();

    UserResponse getUser(Integer id);
}
