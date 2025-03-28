package com.ammfec.web_client;

import com.ammfec.dto.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-user-service", url = "${library.users.api.url}")
public interface UserClient {

    @GetMapping("/users/{id}")
    ResponseEntity<UserResponse> getUser(@PathVariable Integer id);

}
