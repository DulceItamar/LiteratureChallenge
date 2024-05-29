package com.aluracursos.LiteraturaChallenge.repository;

import com.aluracursos.LiteraturaChallenge.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

}
