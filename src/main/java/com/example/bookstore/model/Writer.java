package com.example.bookstore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "writers")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "writer_id")
    private Long id;
    @Column(name = "writer_name")
    private String name;

    protected Writer() {

    }

    public Writer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
