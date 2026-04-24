package com.example.projection.service;

import com.example.projection.dto.AuthorResponse;
import com.example.projection.dto.AuthorWithBooksProjection;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllWithNPlus1();
    List<AuthorWithBooksProjection> getAllWithBooksOptimized();
}
