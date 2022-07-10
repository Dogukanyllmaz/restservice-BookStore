package com.example.bookstore.repository;

import com.example.bookstore.model.Writer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends CrudRepository<Writer,Long> {
}
