package com.ammfec.service;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserServiceImp implements UserService {
    RestTemplate restTemplate = new RestTemplate();

    @Value("${library.users.url-base}")
    private String baseUrl;

    @Override
    public UsersResponse getAllUsers() {
        log.info("called getAllUsers to users service {}", baseUrl);
        ResponseEntity<UsersResponse> response = restTemplate.getForEntity( baseUrl + "/users", UsersResponse.class);
        return response.getBody();
    }

    @Override
    public UserResponse getUser(Integer id) {
        log.info("called getUser to users service {}", baseUrl);
        ResponseEntity<UserResponse> response = restTemplate.getForEntity( baseUrl + "/users/" + id, UserResponse.class);
        return response.getBody();
    }
}
