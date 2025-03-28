package com.ammfec.service;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import com.ammfec.web_client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserClient userClient;

    @Override
    public UsersResponse getAllUsers() {
        log.info("called getAllUsers to users service");
        ResponseEntity<UsersResponse> response = userClient.getUsers();
        return response.getBody();
    }

    @Override
    public UserResponse getUser(Integer id) {
        log.info("called getUser to users service");
        ResponseEntity<UserResponse> response = userClient.getUser(id);
        return response.getBody();
    }
}
