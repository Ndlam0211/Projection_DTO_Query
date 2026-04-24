package com.example.projection.service.impl;

import com.example.projection.dto.AuthorResponse;
import com.example.projection.dto.AuthorWithBooksProjection;
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

    /**
     * Cách cũ: Fetch entity rồi map manual (có vấn đề circular reference)
     */
    @Transactional(readOnly = true)
    public List<AuthorResponse> getAllWithNPlus1() {
        List<Author> authors = authorRepo.findAllWithBook();

        return authors.stream().map(author -> {
            List<String> bookTitles = author.getBooks().stream()
                    .map(Book::getTitle)
                    .toList();

            return new AuthorResponse(author.getId(), author.getName(), bookTitles);
        }).toList();
    }

    /**
     * Cách tối ưu 2: Sử dụng nested projection (author + books)
     * - Tránh hoàn toàn circular reference
     * - Một query duy nhất với JOIN FETCH
     * - Dữ liệu sạch và tối ưu
     */
    public List<AuthorWithBooksProjection> getAllWithBooksOptimized() {
        return authorRepo.findAllWithBooksProjection();
    }
}
