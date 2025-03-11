package org.example.kino_marts.repository;

import org.example.kino_marts.model.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Giver automatisk CRUD-operationer på MovieShow-entitete dvs. ingen sql
@Repository
public interface MovieShowRepo extends JpaRepository<MovieShow, Integer> {
}

