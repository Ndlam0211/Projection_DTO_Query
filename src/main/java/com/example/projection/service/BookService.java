package com.example.projection.service;

import com.example.projection.dto.BookWithProjection;
import com.example.projection.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    List<BookWithProjection> getAllWithProjection();
}
