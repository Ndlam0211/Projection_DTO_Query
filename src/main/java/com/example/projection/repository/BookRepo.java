package com.example.projection.repository;

import com.example.projection.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    // find all books and return them as a list of the specified type.
    // The type can be an entity/dto class or a projection interface.
    <T> List<T> findBy(Class<T> type);
}
