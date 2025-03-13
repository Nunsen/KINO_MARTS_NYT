package org.example.kino_marts.controller;

import org.example.kino_marts.model.MovieShow;
import org.example.kino_marts.model.MovieShowTime;
import org.example.kino_marts.repository.MovieShowRepo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*") // Tillader adgang fra alle domæner
@RestController
@RequestMapping("/api/movieshows") // Alle endpoints starter med /api/movieshows
public class MovieShowController {
    private final MovieShowRepo movieShowRepo;

    public MovieShowController(MovieShowRepo movieShowRepo) {
        this.movieShowRepo = movieShowRepo;
    }

    // Hent alle filmvisninger med MovieShowTime inkluderet
    @GetMapping
    public List<Map<String, Object>> getAllMovieShows() {
        List<MovieShow> movieShows = movieShowRepo.findAll();
        List<Map<String, Object>> response = new ArrayList<>();

        for (MovieShow show : movieShows) {
            Map<String, Object> showData = new HashMap<>();
            showData.put("movie", show.getMovie());
            showData.put("date_of_movie", show.getDate_of_movie());

            // Hent visningstider for dette MovieShow
            List<Map<String, Object>> showTimesList = new ArrayList<>();
            for (MovieShowTime time : show.getMovieShowTimes()) {
                Map<String, Object> timeData = new HashMap<>();
                timeData.put("start_time", time.getStart_time());
                timeData.put("end_time", time.getEnd_time());
                timeData.put("show_time_id", time.getShow_time_id());
                showTimesList.add(timeData);
            }

            showData.put("showTimes", showTimesList);
            response.add(showData);
        }

        return response;
    }

    // Hent en specifik filmvisning via ID
    @GetMapping("/{id}")
    public Map<String, Object> getMovieShowById(@PathVariable int id) {
        Optional<MovieShow> movieShowOptional = movieShowRepo.findById(id);
        if (movieShowOptional.isPresent()) {
            MovieShow show = movieShowOptional.get();
            Map<String, Object> showData = new HashMap<>();
            showData.put("movie", show.getMovie());
            showData.put("date_of_movie", show.getDate_of_movie());

            List<Map<String, Object>> showTimesList = new ArrayList<>();
            for (MovieShowTime time : show.getMovieShowTimes()) {
                Map<String, Object> timeData = new HashMap<>();
                timeData.put("start_time", time.getStart_time());
                timeData.put("end_time", time.getEnd_time());
                timeData.put("show_time_id", time.getShow_time_id());
                showTimesList.add(timeData);
            }

            showData.put("showTimes", showTimesList);
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