package model;

import jakarta.persistence.*;

@Entity
public class CinemaRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;

    @OneToOne
    @JoinColumn(name = "movie_show_id", nullable = false) // Fremmednøgle fra movie_show
    private MovieShow movieShow;
    private String room_name;
    private int amount_of_seats;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getAmount_of_seats() {
        return amount_of_seats;
    }

    public void setAmount_of_seats(int amount_of_seats) {
        this.amount_of_seats = amount_of_seats;
    }


}
