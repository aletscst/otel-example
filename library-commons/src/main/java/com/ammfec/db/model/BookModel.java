package com.ammfec.db.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "edition")
    private String edition;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;
}
