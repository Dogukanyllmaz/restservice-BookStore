package com.example.bookstore.controller;

import com.example.bookstore.model.Writer;
import com.example.bookstore.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writers/")
public class WriterController {

    private WriterRepository writerRepository;

    @Autowired
    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @GetMapping("")
    public List<Writer> getAllWriter() {
        return (List<Writer>) writerRepository.findAll();
    }

    @PostMapping("")
    public ResponseEntity<Writer> createWriter(@RequestBody Writer writer) {
        writerRepository.save(writer);
        return ResponseEntity.status(HttpStatus.CREATED).body(writer);
    }


}
