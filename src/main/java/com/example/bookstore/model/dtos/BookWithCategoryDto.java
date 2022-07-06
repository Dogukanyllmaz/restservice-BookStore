package com.example.bookstore.model.dtos;


public class BookWithCategoryDto {

    private Long id;
    private String bookName;
    private String categoryName;

    protected BookWithCategoryDto() {

    }

    public BookWithCategoryDto(Long id, String bookName, String categoryName) {
        this.id = id;
        this.bookName = bookName;
        this.categoryName = categoryName;
    }
}
