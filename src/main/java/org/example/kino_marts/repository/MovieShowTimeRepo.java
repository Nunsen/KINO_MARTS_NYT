package org.example.kino_marts.repository;

import org.example.kino_marts.model.MovieShow;
import org.example.kino_marts.model.MovieShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieShowTimeRepo extends JpaRepository<MovieShowTime, Integer> {
}

