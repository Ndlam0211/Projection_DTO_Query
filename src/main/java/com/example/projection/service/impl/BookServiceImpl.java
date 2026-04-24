package com.example.projection.service.impl;

import com.example.projection.dto.BookWithProjection;
import com.example.projection.entity.Book;
import com.example.projection.repository.BookRepo;
import com.example.projection.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public List<BookWithProjection> getAllWithProjection() {
        return bookRepo.findBy(BookWithProjection.class);
    }
}
