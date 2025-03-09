package com.ammfec.controller;

import com.ammfec.dto.User;
import com.ammfec.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        log.info("getting users");
        try {
            return ResponseEntity.ok(service.getUsers());
        } catch (Exception e) {
            log.error("error getting users", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        log.info("getting user: {}", id);
        try {
            User user = service.getUser(id);
            if(user == null) {
                log.error("user not found: {}", id);
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(user);
        } catch (Exception e) {
            log.error("error getting user: {}", id, e);
            return ResponseEntity.internalServerError().build();
        }
    }

}
