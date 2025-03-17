package com.ammfec.service;

import com.ammfec.db.model.BookModel;
import com.ammfec.db.repository.BookRepository;
import com.ammfec.dto.general.Book;
import com.ammfec.dto.request.BookRequest;
import com.ammfec.dto.response.BookResponse;
import com.ammfec.dto.response.BooksResponse;
import com.ammfec.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public BooksResponse getBooks() {
        Iterable<BookModel> booksModel = repository.findAll();

        BooksResponse booksResponse = new BooksResponse();
        List<Book> books = new ArrayList<>();

        for (BookModel bookModel : booksModel) {
            Book book = new Book();
            book.setCode(bookModel.getCode());
            book.setTitle(bookModel.getTitle());
            book.setAuthor(bookModel.getAuthor());
            book.setEdition(bookModel.getEdition());
            book.setDescription(bookModel.getDescription());
            book.setImage(bookModel.getImage());

            books.add(book);
        }

        booksResponse.setBooks(books);

        return booksResponse;
    }

    @Override
    public BookResponse getBook(Integer id) {
        BookModel bookModel = repository.findById(id).orElseThrow(() -> {
            log.error("Book " + id + " not found");
            return new NotFoundException("Book " + id + " not found");
        });

        BookResponse bookResponse = new BookResponse();
        bookResponse.setId(bookModel.getId());

        Book book = new Book();

        book.setId(bookModel.getId());
        book.setCode(bookModel.getCode());
        book.setTitle(bookModel.getTitle());
        book.setAuthor(bookModel.getAuthor());
        book.setEdition(bookModel.getEdition());
        book.setDescription(bookModel.getDescription());
        book.setImage(bookModel.getImage());

        bookResponse.setBook(book);

        return bookResponse;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        return null;
    }

    @Override
    public BookResponse updateBook(Integer id, BookRequest bookRequest) {
        return null;
    }

    @Override
    public void deleteBook(Integer id) {

    }
}
