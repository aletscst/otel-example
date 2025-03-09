package com.ammfec.service;

import com.ammfec.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    RestTemplate restTemplate = new RestTemplate();

    @Value("${library.users.url-base}")
    private String baseUrl;

    @Override
    public List<User> getAllUsers() {
        ResponseEntity<User[]> response = restTemplate.getForEntity( baseUrl + "/users", User[].class);
        return List.of(response.getBody());
    }
}
