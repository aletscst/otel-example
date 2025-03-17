package com.ammfec.controller;

import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import com.ammfec.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity<BooksResponse> getAllBooks() {
        log.info("getAllBooks from library controller");
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Integer id) {
        log.info("getBookById from library controller");
        return ResponseEntity.ok(bookService.getBookById(id));
    }
}
