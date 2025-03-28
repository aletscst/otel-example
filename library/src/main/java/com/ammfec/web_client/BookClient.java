package com.ammfec.web_client;

import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", url = "${library.books.url-base}")
public interface BookClient {

    @GetMapping("/books")
    ResponseEntity<BooksResponse> getBooks();

    @GetMapping("/books/{id}")
    ResponseEntity<BookResponse> getBookById(@PathVariable Integer id);

}
