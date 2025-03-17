package com.ammfec.controller;

import com.ammfec.dto.request.BookRequest;
import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import com.ammfec.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "")
    public ResponseEntity<BooksResponse> getBooks() {
        log.info("getting books");

        return ResponseEntity.ok(bookService.getBooks());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable Integer id) {
        log.info("getting book {}", id);

        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest) {
        log.info("creating book {}", bookRequest);

        return ResponseEntity.status(201).body(bookService.createBook(bookRequest));
    }
}
