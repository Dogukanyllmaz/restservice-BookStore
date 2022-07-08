package com.example.bookstore.model;




import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


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

    @ManyToMany()
    @JoinColumn(name = "book_id")
    private List<Writer> writers;


    protected Book () {

    }

    public Book(String name,Category category,List<Writer> writer) {
        this.name = name;
        this.category = category;
        this.writers = writer;
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

    public List<Writer> getWriter() {
        return writers;
    }
}
