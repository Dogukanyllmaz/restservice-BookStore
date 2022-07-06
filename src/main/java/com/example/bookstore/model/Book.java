package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String writer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date madeYear;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    protected Book () {

    }

    public Book(String name, String writer, Date madeYear) {
        this.name = name;
        this.writer = writer;
        this.madeYear = madeYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public Date getMadeYear() {
        return madeYear;
    }


}
