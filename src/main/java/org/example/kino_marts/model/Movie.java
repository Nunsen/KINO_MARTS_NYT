package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int movie_id;
    private String title;
    private String genre;
    private int age_requirement;


    private int release_year;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false) // Fremmednøgle fra Actor
    @JsonBackReference
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false) // Fremmednøgle fra Instructor
    @JsonBackReference
    private Instructor instructor;


    // Rettet til en liste, da en film kan have flere visninger
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonManagedReference // Ejer relationen (forælder) vi sikrer at vi kan serialisere til JSON
    private List<MovieShow> movieShows;

    private String movie_photo;
    private String resume;

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge_requirement() {
        return age_requirement;
    }

    public void setAge_requirement(int age_requirement) {
        this.age_requirement = age_requirement;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getMovie_photo() {
        return movie_photo;
    }

    public void setMovie_photo(String movie_photo) {
        this.movie_photo = movie_photo;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
