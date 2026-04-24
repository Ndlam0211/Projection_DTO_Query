package com.example.projection.controller;

import com.example.projection.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<?> getAll() {

        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/projection")
    public ResponseEntity<?> getAllWithProjection() {

        return ResponseEntity.ok(bookService.getAllWithProjection());
    }
}
