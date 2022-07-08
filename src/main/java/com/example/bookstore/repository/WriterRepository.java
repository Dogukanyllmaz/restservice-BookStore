package com.example.bookstore.repository;

import com.example.bookstore.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WriterRepository extends JpaRepository<Writer,Long> {
}
