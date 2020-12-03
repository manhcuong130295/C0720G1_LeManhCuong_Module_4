package com.codegym.service;

import com.codegym.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findAll();
    void save(Book book);
    void remove(int id);
    Book findById(int id);
}
