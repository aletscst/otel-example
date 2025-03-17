package com.ammfec.service;

import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class BookServiceImp implements BookService {
    RestTemplate restTemplate = new RestTemplate();

    @Value("${library.books.url-base}")
    private String baseUrl;

    @Override
    public BooksResponse getAllBooks() {
        log.info("called getAllBooks to library service {}", baseUrl);
        ResponseEntity<BooksResponse> response = restTemplate.getForEntity( baseUrl + "/books", BooksResponse.class);
        return response.getBody();
    }

    @Override
    public BookResponse getBookById(Integer id) {
        log.info("called getBookById to library service {}", baseUrl);
        ResponseEntity<BookResponse> response = restTemplate.getForEntity( baseUrl + "/books/" + id, BookResponse.class);
        return response.getBody();
    }
}
