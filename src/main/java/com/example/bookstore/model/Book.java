package com.example.bookstore.model;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "books")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "writer_id")
    private Writer writer;


    protected Book () {

    }

    public Book(String name,Category category,Writer writer) {
        this.name = name;
        this.category = category;
        this.writer = writer;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Category getCategory() {
        return category;
    }

    public Writer getWriter() {
        return writer;
    }
}
