package org.example.kino_marts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int booking_id;

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false) // Fremmednøgle fra Customer
    private Customer customer;

    private Date date_of_movie;
    private String status_payment;

    // En booking SKAL have en MovieShow, men movieshow behøves ikke booking!
    @OneToOne
    @JoinColumn(name = "movie_show_id", nullable = false) // Fremmednøgle fra MovieShow
    private MovieShow movieShow;




    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate_of_movie() {
        return date_of_movie;
    }

    public void setDate_of_movie(Date date_of_movie) {
        this.date_of_movie = date_of_movie;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public String getStatus_payment() {
        return status_payment;
    }

    public void setStatus_payment(String status_payment) {
        this.status_payment = status_payment;
    }

}

