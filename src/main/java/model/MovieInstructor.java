package model;

import jakarta.persistence.*;

@Entity
public class MovieInstructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Primærnøgle

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor; // Fremmednøgle fra Instructor

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Fremmednøgle fra Movie

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;

