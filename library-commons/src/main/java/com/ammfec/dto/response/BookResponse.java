package com.ammfec.dto.response;

import com.ammfec.dto.general.Book;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BookResponse extends BasicResponse {
    private Book book;
}
