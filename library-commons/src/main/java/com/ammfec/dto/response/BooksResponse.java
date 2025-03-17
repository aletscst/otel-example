package com.ammfec.dto.response;

import com.ammfec.dto.general.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BooksResponse extends BasicResponse {
    private List<Book> books;
}
