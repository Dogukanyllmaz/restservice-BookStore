package com.example.bookstore.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "books")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_category" ,
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_writer",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private Set<Writer> writers = new HashSet<>();

    protected Book () {
    }

    public Book(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setWriters(Set<Writer> writers) {
        this.writers = writers;
    }
}
