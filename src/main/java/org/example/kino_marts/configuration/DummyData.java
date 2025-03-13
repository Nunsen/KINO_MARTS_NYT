package org.example.kino_marts.configuration;
import org.example.kino_marts.model.*;
import org.example.kino_marts.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyData {
    @Bean
    CommandLineRunner initDatabase(
            MovieRepo movieRepo,
            MovieShowRepo movieShowRepo,
            BookingRepo bookingRepo,
            ActorRepo actorRepo,
            MovieActorRepo movieActorRepo,
            InstructorRepo instructorRepo,
            CinemaRoomRepo cinemaRoomRepo,
            CustomerRepo customerRepo,
            SeatRepo seatRepo
    ) {
        return args -> {
            System.out.println("📀 DummyData bliver kaldt!"); // 👈 Log i terminalen
            // Hvis der allerede findes data, så stop
            if (movieRepo.count() > 0) return;

            System.out.println("📀 Indsætter dummy data...");

            // Opret instruktører
            Instructor nolan = new Instructor();
            nolan.setInstructor_first_name("Christopher");
            nolan.setInstructor_last_name("Nolan");
            nolan.setBirth_date_instructor(LocalDate.parse("1970-07-30"));

            instructorRepo.save(nolan);

            // Opret skuespillere
            Actor actor1 = new Actor();
            actor1.setActor_first_name("Leonardo");
            actor1.setActor_last_name("DiCaprio");
            actor1.setBirth_date_actor(LocalDate.parse("1974-11-11"));

            Actor actor2 = new Actor();
            actor2.setActor_first_name("Matthew");
            actor2.setActor_last_name("McConaughey");
            actor2.setBirth_date_actor(LocalDate.parse("1969-11-04"));

            actorRepo.save(actor1);
            actorRepo.save(actor2);

            // Opret film
            Movie inception = new Movie();
            inception.setTitle("Inception");
            inception.setGenre("Sci-Fi");
            inception.setAge_requirement(13);
            inception.setRelease_year(2010);
            inception.setActor(actor1);
            inception.setInstructor(nolan);
            inception.setMovie_photo("https://scale.coolshop-cdn.com/product-media.coolshop-cdn.com/AB397S/ea81c4f8324449c0b8ef0c225c51b634.JPEG/f/inception-dvd.JPEG");
            inception.setResume("A thief who enters dreams...");

            Movie interstellar = new Movie();
            interstellar.setTitle("Interstellar");
            interstellar.setGenre("Sci-Fi");
            interstellar.setAge_requirement(12);
            interstellar.setRelease_year(2014);
            interstellar.setActor(actor2);
            interstellar.setInstructor(nolan);
            interstellar.setMovie_photo("https://imusic.b-cdn.net/images/item/original/935/5051892182935.jpg?interstellar-2015-interstellar-dvd&class=scaled&v=1691753575");
            interstellar.setResume("A space exploration story...");

            movieRepo.save(inception);
            movieRepo.save(interstellar);

            // Opret relationer mellem film og skuespillere
            MovieActor movieActor1 = new MovieActor();
            movieActor1.setMovie(inception);
            movieActor1.setActor(actor1);

            MovieActor movieActor2 = new MovieActor();
            movieActor2.setMovie(interstellar);
            movieActor2.setActor(actor2);

            movieActorRepo.save(movieActor1);
            movieActorRepo.save(movieActor2);



            // Opret kunder
            Customer customer1 = new Customer();
            customer1.setCustomer_first_name("John");
            customer1.setCustomer_last_name("Doe");
            customer1.setPhone_number("12345678");

            Customer customer2 = new Customer();
            customer2.setCustomer_first_name("Jane");
            customer2.setCustomer_last_name("Smith");
            customer2.setPhone_number("87654321");

            customerRepo.save(customer1);
            customerRepo.save(customer2);

            // Opret filmvisninger
            MovieShow show1 = new MovieShow();
            show1.setMovie(inception);
            show1.setDate_of_movie(LocalDate.of(2024, 6, 10));
            show1.setStart_time(LocalDateTime.of(2024, 6, 10, 14, 0));
            show1.setEnd_time(LocalDateTime.of(2024, 6, 10, 18, 0));
            movieShowRepo.save(show1);

            MovieShow show2 = new MovieShow();
            show2.setMovie(interstellar);
            show2.setDate_of_movie(LocalDate.of(2024, 6, 12));
            show2.setStart_time(LocalDateTime.of(2024, 6, 10, 14, 0));
            show2.setEnd_time(LocalDateTime.of(2024, 6, 10, 18, 0));
            movieShowRepo.save(show2);

            MovieShow show3 = new MovieShow();
            show3.setMovie(interstellar);
            show3.setDate_of_movie(LocalDate.of(2024, 6, 12));
            show3.setStart_time(LocalDateTime.of(2024, 6, 10, 17, 0));
            show3.setEnd_time(LocalDateTime.of(2024, 6, 10, 20, 0));
            movieShowRepo.save(show3);


            // Opret bookinger
            Booking booking1 = new Booking();
            booking1.setCustomer(customer1);
            booking1.setDate_of_movie(LocalDate.now());
            booking1.setMovieShow(show1);
            booking1.setStatus_payment("Paid");

            Booking booking2 = new Booking();
            booking2.setCustomer(customer2);
            booking2.setDate_of_movie(LocalDate.now().plusDays(1));
            booking2.setMovieShow(show2);
            booking2.setStatus_payment("Not Paid");

            bookingRepo.save(booking1);
            bookingRepo.save(booking2);

            // Opret biografsale
            CinemaRoom room1 = new CinemaRoom();
            room1.setRoom_name("Sal 1");
            room1.setAmount_of_seats(50);
            room1.setMovieShow(show1);

            CinemaRoom room2 = new CinemaRoom();
            room2.setRoom_name("Sal 2");
            room2.setAmount_of_seats(40);
            room2.setMovieShow(show2);

            cinemaRoomRepo.save(room1);
            cinemaRoomRepo.save(room2);


            // Opret sæder
            List<Seat> seats = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                Seat seat = new Seat();
                seat.setSeat_name("Seat " + i);
                seat.setOccupied(false);
                seat.setRoom_id(room1);
                seat.setBooking_id(booking1);
                seat.setPrice_of_seat(100);
                seats.add(seat);
            }

            for (int i = 11; i <= 20; i++) {
                Seat seat = new Seat();
                seat.setSeat_name("Seat " + i);
                seat.setOccupied(false);
                seat.setRoom_id(room2);
                seat.setBooking_id(booking2);
                seat.setPrice_of_seat(120);
                seats.add(seat);
            }

            seatRepo.saveAll(seats);

            System.out.println("✅ Dummy data indsat i databasen!");
        };
    }
}
