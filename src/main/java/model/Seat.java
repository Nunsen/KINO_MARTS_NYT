package model;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int seat_id;

    @ManyToOne //en biografsal kan have mange sæder
    @JoinColumn(name = "room_id", nullable = false) // Fremmednøgle fra CinemaRoom
    private CinemaRoom cinemaRoom;
    private String seat_name;
    private boolean occupied;

    @ManyToOne //en booking kan have mange sæder
    @JoinColumn(name = "booking_id", nullable = false) // Fremmednøgle fra Booking
    private Booking booking;

    private int price_of_seat;

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public CinemaRoom getRoom_id() {
        return cinemaRoom;
    }

    public void setRoom_id(CinemaRoom cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public String getSeat_name() {
        return seat_name;
    }

    public void setSeat_name(String seat_name) {
        this.seat_name = seat_name;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getPrice_of_seat() {
        return price_of_seat;
    }

    public void setPrice_of_seat(int price_of_seat) {
        this.price_of_seat = price_of_seat;
    }
}
