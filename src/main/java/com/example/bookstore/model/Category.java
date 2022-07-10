package com.example.bookstore.model;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String name;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnoreProperties("categories")
    private List<Book> books;

    protected Category() {

    }

    public Category( String name, List<Book> books) {
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
