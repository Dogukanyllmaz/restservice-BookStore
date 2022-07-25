package com.example.bookstore.controller;

import com.example.bookstore.model.Category;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories/")
public class CategoryController {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }


    @PostMapping("")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }




}
