package com.ammfec.controller;

import com.ammfec.dto.User;
import com.ammfec.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        log.info("getAllUsers from library controller");
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
