package com.ammfec.service;

import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import com.ammfec.web_client.BookClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookClient bookClient;

    @Override
    public BooksResponse getAllBooks() {
        log.info("called getAllBooks to library service");
        ResponseEntity<BooksResponse> response = bookClient.getBooks();
        return response.getBody();
    }

    @Override
    public BookResponse getBookById(Integer id) {
        log.info("called getBookById to library service");
        ResponseEntity<BookResponse> response = bookClient.getBookById(id);
        return response.getBody();
    }
}
