package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

       // Book getByBookName(String bookName);
       // Book getByBookNameAndCategory_CategoryId(String bookName, Long categoryId);

}
