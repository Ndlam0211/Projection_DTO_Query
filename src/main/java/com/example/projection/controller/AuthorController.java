package com.example.projection.controller;

import com.example.projection.dto.AuthorResponse;
import com.example.projection.dto.AuthorWithBooksProjection;
import com.example.projection.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    /**
     * Cách cũ - có vấn đề circular reference (được sửa bằng @JsonManagedReference/@JsonBackReference)
     */
    @GetMapping("/n-plus-1")
    public ResponseEntity<List<AuthorResponse>> getAllWithNPlus1() {

        return ResponseEntity.ok(authorService.getAllWithNPlus1());
    }


    /**
     * Cách tối ưu 2 - Sử dụng nested projection (author + books)
     * - Tránh circular reference hoàn toàn
     * - Một query JOIN FETCH
     * - Dữ liệu đầy đủ nhưng sạch
     */
    @GetMapping("/with-books")
    public ResponseEntity<List<AuthorWithBooksProjection>> getAllWithBooksOptimized() {

        return ResponseEntity.ok(authorService.getAllWithBooksOptimized());
    }
}
