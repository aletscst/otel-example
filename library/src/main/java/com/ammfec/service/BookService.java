package com.ammfec.service;

import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;

public interface BookService {
    BooksResponse getAllBooks();

    BookResponse getBookById(Integer id);
}
