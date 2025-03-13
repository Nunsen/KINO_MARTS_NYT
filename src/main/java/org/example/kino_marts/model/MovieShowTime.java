package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MovieShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int show_time_id;

    @ManyToOne
    @JoinColumn(name = "movie_show_id", nullable = false)
    @JsonBackReference
    private MovieShow movieShow;

    private LocalDateTime start_time;
    private LocalDateTime end_time;

    public int getShow_time_id() {
        return show_time_id;
    }

    public void setShow_time_id(int show_time_id) {
        this.show_time_id = show_time_id;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }
}
