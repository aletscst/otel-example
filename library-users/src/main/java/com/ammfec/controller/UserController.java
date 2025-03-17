package com.ammfec.controller;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import com.ammfec.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public ResponseEntity<UsersResponse> getUsers() {
        log.info("getting users");
        return ResponseEntity.ok(service.getUsers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
        log.info("getting user: {}", id);

        UserResponse user = service.getUser(id);
        user.setCode(HttpStatus.OK.value());
        return ResponseEntity.ok(user);
    }

}
