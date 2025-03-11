package org.example.kino_marts.repository;

import org.example.kino_marts.model.MovieInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieInstructorRepo extends JpaRepository<MovieInstructor, Integer> {
}
