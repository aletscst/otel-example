package com.ammfec.web_client;

import com.ammfec.dto.response.BookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "loan-book-service", url = "${library.books.api.url}")
public interface BookClient {

    @GetMapping("/books/{bookId}")
    ResponseEntity<BookResponse> getBook(@PathVariable Integer bookId);

}
