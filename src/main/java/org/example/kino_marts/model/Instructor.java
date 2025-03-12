package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instructor_id;

    private String instructor_first_name;
    private String instructor_last_name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birth_date_instructor;

    // En instruktør kan instruere mange film via MovieInstructor
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MovieInstructor> movies;



    // Getters & Setters
    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_first_name() {
        return instructor_first_name;
    }

    public void setInstructor_first_name(String instructor_first_name) {
        this.instructor_first_name = instructor_first_name;
    }

    public String getInstructor_last_name() {
        return instructor_last_name;
    }

    public void setInstructor_last_name(String instructor_last_name) {
        this.instructor_last_name = instructor_last_name;
    }

    public LocalDate getBirth_date_instructor() {
        return birth_date_instructor;
    }

    public void setBirth_date_instructor(LocalDate birth_date_instructor) {
        this.birth_date_instructor = birth_date_instructor;
    }

    public List<MovieInstructor> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieInstructor> movies) {
        this.movies = movies;
    }
}
