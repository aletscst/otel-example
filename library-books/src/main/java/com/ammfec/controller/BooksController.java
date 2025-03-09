package com.ammfec.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping(value = "")
    public ResponseEntity<String> getBooks() {
        log.info("getBooks invoked");
        return ResponseEntity.ok("books");
    }
}
