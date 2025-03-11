package org.example.kino_marts.controller;


import org.example.kino_marts.model.MovieShow;
import org.springframework.web.bind.annotation.*;
import org.example.kino_marts.repository.MovieShowRepo;

import java.util.List;

//RestController returnerer JSON (tekst), vi adskiller backend og frontend
@RestController
@RequestMapping("/api/movieshows")
public class MovieShowController {
    private final MovieShowRepo movieShowRepo;

    public MovieShowController(MovieShowRepo movieShowRepo) {
        this.movieShowRepo = movieShowRepo;
    }

    // Hent alle filmvisninger
    @GetMapping
    public List<MovieShow> getAllMovieShows() {
        return this.movieShowRepo.findAll();
    }

    // Hent en specifik filmvisning via ID
    @GetMapping("/{id}")
    public MovieShow getMovieShowById(@PathVariable int id) {
        return this.movieShowRepo.findById(id).orElse(null);
    }

    // Opret en ny filmvisning
    @PostMapping
    public MovieShow createMovieShow(@RequestBody MovieShow movieShow) {
        return this.movieShowRepo.save(movieShow);
    }

    // Slet en filmvisning via ID
    @DeleteMapping("/{id}")
    public void deleteMovieShow(@PathVariable int id) {
        this.movieShowRepo.deleteById(id);
    }
}

