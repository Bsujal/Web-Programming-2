package com.example.movieticketingsystem.repositories;

import com.example.movieticketingsystem.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
