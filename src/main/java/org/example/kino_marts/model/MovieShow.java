package org.example.kino_marts.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class MovieShow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_show_id;

    @OneToOne
    @JoinColumn(name = "movie_id", nullable = false) // Fremmednøgle fra Movie
    private Movie movie_id;

    private Date start_time;
    private Date end_time;
    private Date date_of_movie;

    public int getMovie_show_id() {
        return movie_show_id;
    }

    public void setMovie_show_id(int movie_show_id) {
        this.movie_show_id = movie_show_id;
    }

    public Movie getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie_id = movie_id;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getDate_of_movie() {
        return date_of_movie;
    }

    public void setDate_of_movie(Date date_of_movie) {
        this.date_of_movie = date_of_movie;}
    }


