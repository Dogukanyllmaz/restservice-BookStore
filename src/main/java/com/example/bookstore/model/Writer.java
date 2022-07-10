package com.example.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writers")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "writer_id")
    private Long id;
    @Column(name = "writer_name")
    private String name;
    @ManyToMany(mappedBy = "writers")
    private List<Book> books;

    protected Writer() {

    }

    public Writer(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
