package com.ammfec.controller;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import com.ammfec.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<UsersResponse> getAllUsers() {
        log.info("getAllUsers from library controller");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
        log.info("getUser from library controller");
        return ResponseEntity.ok(userService.getUser(id));
    }
}
