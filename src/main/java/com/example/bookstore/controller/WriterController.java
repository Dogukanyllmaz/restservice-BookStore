package com.example.bookstore.controller;

import com.example.bookstore.model.Writer;
import com.example.bookstore.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/writer/")
public class WriterController {

    private WriterRepository writerRepository;

    @Autowired
    public WriterController(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @GetMapping("")
    public List<Writer> getAllWriters() {
        return (List<Writer>) writerRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Writer>> getWriterById(@PathVariable Long id) {
        Optional<Writer> writer = writerRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(writer);
    }

    @PostMapping("")
    public ResponseEntity<Writer> createWriter(@RequestBody Writer writer) {
        writerRepository.save(writer);
        return ResponseEntity.status(HttpStatus.CREATED).body(writer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Writer> removeWriter(@PathVariable Long id) {
        try {
            writerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
