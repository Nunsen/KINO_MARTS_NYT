package org.example.kino_marts.repository;

import org.example.kino_marts.model.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRoomRepo extends JpaRepository<CinemaRoom, Integer> {
}
