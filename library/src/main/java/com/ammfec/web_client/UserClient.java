package com.ammfec.web_client;

import com.ammfec.dto.response.UserResponse;
import com.ammfec.dto.response.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${library.users.url-base}")
public interface UserClient {

    @GetMapping("/users")
    ResponseEntity<UsersResponse> getUsers();

    @GetMapping("/users/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable Integer id);

}
