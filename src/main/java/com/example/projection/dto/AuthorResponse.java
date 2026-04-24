package com.example.projection.dto;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Interface-based projection for Author
 * Spring Data JPA sẽ tự động ánh xạ dữ liệu từ database
 */
@AllArgsConstructor
public class AuthorResponse {
    private Integer id;
    private String name;
    private List<String> bookTitles;
}
