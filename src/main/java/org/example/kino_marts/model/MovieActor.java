package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primærnøgle

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    @JsonBackReference
    private Actor actor; // Fremmednøgle fra Actor

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Fremmednøgle fra Movie

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
