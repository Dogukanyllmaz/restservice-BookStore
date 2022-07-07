package com.example.bookstore.model;




import javax.persistence.*;


@Entity
@Table(name = "books")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_name")
    private String name;
    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    protected Book () {

    }

    public Book(Long id,String name,Category category) {
        this.id = id;
        this.name = name;
        this.category =category;
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

}
