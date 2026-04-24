package com.example.projection.dto;

// projection interface for Book entity, it only contains the fields we want to return in the response.
public interface BookWithProjection {
    String getTitle();
    AuthorInfo getAuthor();

    interface AuthorInfo {
        String getName();
    }
}

