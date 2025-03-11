package org.example.kino_marts.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    private String actor_first_name;
    private String actor_last_name;
    private Date birth_date_actor;

    // En skuespiller kan have mange filmrelationer via MovieActor
    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private List<MovieActor> movies;

    // Getters & Setters
    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getActor_first_name() {
        return actor_first_name;
    }

    public void setActor_first_name(String actor_first_name) {
        this.actor_first_name = actor_first_name;
    }

    public String getActor_last_name() {
        return actor_last_name;
    }

    public void setActor_last_name(String actor_last_name) {
        this.actor_last_name = actor_last_name;
    }

    public Date getBirth_date_actor() {
        return birth_date_actor;
    }

    public void setBirth_date_actor(Date birth_date_actor) {
        this.birth_date_actor = birth_date_actor;
    }

    public List<MovieActor> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieActor> movies) {
        this.movies = movies;
    }
}
