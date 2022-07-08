package com.example.bookstore.controller;

import com.example.bookstore.model.Category;
import com.example.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("")
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(category);
    }

    @PostMapping("")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> removeCategoryById(@PathVariable Long id) {
        try {
            categoryRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
