package com.ammfec.service;

import com.ammfec.dto.request.BookRequest;
import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;

public interface BookService {
    BooksResponse getBooks();

    BookResponse getBook(Integer id);

    BookResponse createBook(BookRequest bookRequest);

    BookResponse updateBook(Integer id, BookRequest bookRequest);

    void deleteBook(Integer id);
}
