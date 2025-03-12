package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_show_id;

    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false) // Fremmednøgle fra Movie
    @JsonManagedReference // Ejer relationen (forælder) vi sikrer at vi kan serialisere til JSON
    private Movie movie;


    private LocalDateTime start_time;
    private LocalDateTime end_time;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date_of_movie;

    @OneToOne(mappedBy = "movieShow")
    @JsonBackReference
    private CinemaRoom cinemaRoom;



    public int getMovie_show_id() {
        return movie_show_id;
    }

    public void setMovie_show_id(int movie_show_id) {
        this.movie_show_id = movie_show_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
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

    public LocalDate getDate_of_movie() {
        return date_of_movie;
    }

    public void setDate_of_movie(LocalDate date_of_movie) {
        this.date_of_movie = date_of_movie;}
    }


