package com.example.projection.service.impl;

import com.example.projection.dto.AuthorResponse;
import com.example.projection.entity.Author;
import com.example.projection.entity.Book;
import com.example.projection.repository.AuthorRepo;
import com.example.projection.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    @Transactional(readOnly = true)
    public List<AuthorResponse> getAllWithNPlus1() {
        List<Author> authors = authorRepo.findAllWithBook();

        return authors.stream().map(author -> {
            List<String> bookTitles = author.getBooks().stream()
                    .map(Book::getTitle)
                    .toList();

            return AuthorResponse.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .bookTitles(bookTitles)
                    .build();
        }).toList();
    }
}
