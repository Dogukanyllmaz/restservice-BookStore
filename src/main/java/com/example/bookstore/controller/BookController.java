package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;
import com.example.bookstore.model.Writer;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping("{id}")
    Book getOneMovie(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book " + id + " doesn't exist."));
    }


    @DeleteMapping("{id}")
    void deleteBookById(@PathVariable Long id) {
        Boolean bookExist = bookRepository.existsById(id);
        if (!bookExist) {
            throw new IllegalStateException(
                    "Book " + id + "doesn't exist"
            );
        }
        bookRepository.deleteById(id);
    }

    //---------------------------------Category Methods--------------------------------------------
    @GetMapping("{id}/categories")
    ResponseEntity<Set<Category>> getCategoryOfBook(@PathVariable Long id) {
        Book temp = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return ResponseEntity.status(HttpStatus.OK).body(temp.getCategories());
    }

    @PostMapping("{id}/categories")
    public ResponseEntity<Book> addCategoryToBook(@PathVariable Long id, @RequestBody Category category) {
        Book temp = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        temp.getCategories().add(category);
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.save(temp));
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateCategoryOfBook(@PathVariable Long id,@RequestBody Book book) {
        Book temp = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        temp.setCategories(book.getCategories());
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.save(temp));
    }

    //------------------------------- Writer Methods ------------------------------------

    @GetMapping("{id}/writers")
    ResponseEntity<Set<Writer>> getWriterOfBook(@PathVariable Long id) {
        Book temp = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return  ResponseEntity.status(HttpStatus.OK).body(temp.getWriters());
    }

    @PostMapping("{id}/writers")
    public ResponseEntity<Book> addWriterToBook(@PathVariable Long id, @RequestBody Writer writer) {
        Book temp = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        temp.getWriters().add(writer);
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.save(temp));
    }



}
