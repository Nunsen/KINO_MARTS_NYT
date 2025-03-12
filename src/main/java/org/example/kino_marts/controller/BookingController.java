package org.example.kino_marts.controller;

import org.example.kino_marts.model.Booking;
import org.example.kino_marts.repository.BookingRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:63342") // Juster porten hvis nødvendigt
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingRepo bookingRepo;

    public BookingController(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    // Hent alle bookinger
    @GetMapping
    public List<Booking> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        System.out.println("DEBUG: " + bookings);
        return bookings;
    }

    // Hent en specifik booking via ID
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingRepo.findById(id).orElse(null);
    }

    // Opret en ny booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepo.save(booking);
    }

    // Slet en booking via ID
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingRepo.deleteById(id);
    }
}
