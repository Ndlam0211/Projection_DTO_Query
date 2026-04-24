package com.example.projection.dto;

import java.util.List;

/**
 * DTO kết hợp Author với danh sách tiêu đề sách
 */
public interface AuthorWithBooksProjection {
    Integer getId();

    String getName();

    String getAddress();

    // Nested projection để lấy book titles
    List<BookTitleOnly> getBooks();

    interface BookTitleOnly {
        String getTitle();
    }
}
