package com.example.bookstore.model;





import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "books")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_category" ,
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    protected Book () {
    }

    public Book(String name,List<Category> categories ) {
        this.name = name;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }

}
