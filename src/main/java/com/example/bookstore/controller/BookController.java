package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books/")
public class BookController {

    private BookRepository bookRepository;


    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("")
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Book>> getById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(book);
    }

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable Long id) {
        try {
            bookRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }




}
