package com.ammfec.dto.general;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String code;
    private String title;
    private String author;
    private String edition;
    private String description;
    private String image;
}
