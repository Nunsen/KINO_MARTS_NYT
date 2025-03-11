package org.example.kino_marts.model;

import jakarta.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int schedule_id;

    @ManyToOne
    @JoinColumn(name = "shift_id", nullable = false) // Fremmednøgle fra Shift
    private Shift shift;
    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }


}
