package org.example.kino_marts.repository;

import org.example.kino_marts.model.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepo extends JpaRepository<MovieActor, Integer> {
}
