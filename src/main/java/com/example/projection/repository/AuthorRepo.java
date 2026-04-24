package com.example.projection.repository;

import com.example.projection.entity.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books")
    List<Author> findAllWithBook();

    @EntityGraph(attributePaths = {"books"})
    @Query("SELECT a FROM Author a")
    List<Author> findAllWithBookOptimized();
}
