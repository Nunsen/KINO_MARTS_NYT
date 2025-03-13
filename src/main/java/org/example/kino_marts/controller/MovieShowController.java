package org.example.kino_marts.controller;

import org.example.kino_marts.model.MovieShow;
import org.springframework.web.bind.annotation.*;
import org.example.kino_marts.repository.MovieShowRepo;

import java.util.*;

@CrossOrigin(origins = "*") // Tillader adgang fra alle domæner
@RestController
@RequestMapping("/api/movieshows") // Alle endpoints starter med /api/movieshows
public class MovieShowController {
    private final MovieShowRepo movieShowRepo; // Database-repository til at hente og gemme filmvisninger

    // Dependency Injection: MovieShowRepo bliver automatisk sat af Spring Boot
    public MovieShowController(MovieShowRepo movieShowRepo) {
        this.movieShowRepo = movieShowRepo;
    }

    // Hent alle filmvisninger med movie_photo inkluderet
    @GetMapping
    public List<Map<String, Object>> getAllMovieShows() {
        List<MovieShow> movieShows = movieShowRepo.findAll();
        List<Map<String, Object>> response = new ArrayList<>();



        // Konverter hver filmvisning til et simpelt JSON-venligt format
        for (MovieShow show : movieShows) {
            Map<String, Object> showData = new HashMap<>();
            showData.put("id", show.getMovie_show_id());
            showData.put("title", show.getMovie().getTitle());
            showData.put("movie_photo", show.getMovie().getMovie_photo()); // 🔹 Sender billedets URL
            showData.put("date", show.getDate_of_movie().toString());
            showData.put("start_time", show.getStart_time().toString());
            showData.put("end_time", show.getEnd_time().toString());

            response.add(showData); // Tilføjer filmvisningen til listen over resultater
        }

        return response;// Returnerer JSON-liste med filmvisninger
    }

    // Hent en specifik filmvisning via ID
    @GetMapping("/{id}")
    public Map<String, Object> getMovieShowById(@PathVariable int id) {
        Optional<MovieShow> movieShowOptional = movieShowRepo.findById(id);
        if (movieShowOptional.isPresent()) {
            MovieShow show = movieShowOptional.get();
            Map<String, Object> showData = new HashMap<>();
            showData.put("id", show.getMovie_show_id());
            showData.put("title", show.getMovie().getTitle());
            showData.put("movie_photo", show.getMovie().getMovie_photo()); // 🔹 Sender billedets URL
            showData.put("date", show.getDate_of_movie().toString());
            showData.put("start_time", show.getStart_time().toString());
            showData.put("end_time", show.getEnd_time().toString());
            return showData;
        }
        return null;
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
