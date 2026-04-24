package com.example.projection.controller;

import com.example.projection.dto.AuthorResponse;
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

    @GetMapping("/n-plus-1")
    public ResponseEntity<List<AuthorResponse>> getAllWithNPlus1() {

        return ResponseEntity.ok(authorService.getAllWithNPlus1());
    }

//    @GetMapping("/projection")
//    public ResponseEntity<?> getAllWithProjection() {
//
//        return ResponseEntity.ok(authorService.getAllWithProjection());
//    }
}
