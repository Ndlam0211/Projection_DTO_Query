package com.example.projection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();
}
