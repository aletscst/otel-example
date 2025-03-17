package com.ammfec.db.repository;

import com.ammfec.db.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
}
