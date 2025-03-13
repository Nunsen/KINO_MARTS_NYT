package org.example.kino_marts.configuration;

import org.example.kino_marts.model.*;
import org.example.kino_marts.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DummyData {
    @Bean
    CommandLineRunner initDatabase(
            MovieRepo movieRepo,
            MovieShowRepo movieShowRepo,
            MovieShowTimeRepo movieShowTimeRepo, // Nyt repository til MovieShowTime
            BookingRepo bookingRepo,
            ActorRepo actorRepo,
            MovieActorRepo movieActorRepo,
            InstructorRepo instructorRepo,
            CinemaRoomRepo cinemaRoomRepo,
            CustomerRepo customerRepo,
            SeatRepo seatRepo
    ) {
        return args -> {
            System.out.println("📀 DummyData bliver kaldt!");

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

            // Opret filmfremvisninger
            MovieShow inceptionShow = new MovieShow();
            inceptionShow.setMovie(inception);
            inceptionShow.setDate_of_movie(LocalDate.of(2024, 6, 10));

            MovieShow interstellarShow = new MovieShow();
            interstellarShow.setMovie(interstellar);
            interstellarShow.setDate_of_movie(LocalDate.of(2024, 6, 12));

            movieShowRepo.save(inceptionShow);
            movieShowRepo.save(interstellarShow);

            // Opret visningstider til Inception
            MovieShowTime inceptionTime1 = new MovieShowTime();
            inceptionTime1.setMovieShow(inceptionShow);
            inceptionTime1.setStart_time(LocalDateTime.of(2024, 6, 10, 14, 0));
            inceptionTime1.setEnd_time(LocalDateTime.of(2024, 6, 10, 17, 0));

            MovieShowTime inceptionTime2 = new MovieShowTime();
            inceptionTime2.setMovieShow(inceptionShow);
            inceptionTime2.setStart_time(LocalDateTime.of(2024, 6, 10, 18, 0));
            inceptionTime2.setEnd_time(LocalDateTime.of(2024, 6, 10, 21, 0));

            // Opret visningstider til Interstellar
            MovieShowTime interstellarTime1 = new MovieShowTime();
            interstellarTime1.setMovieShow(interstellarShow);
            interstellarTime1.setStart_time(LocalDateTime.of(2024, 6, 12, 15, 0));
            interstellarTime1.setEnd_time(LocalDateTime.of(2024, 6, 12, 18, 0));

            MovieShowTime interstellarTime2 = new MovieShowTime();
            interstellarTime2.setMovieShow(interstellarShow);
            interstellarTime2.setStart_time(LocalDateTime.of(2024, 6, 12, 20, 0));
            interstellarTime2.setEnd_time(LocalDateTime.of(2024, 6, 12, 23, 0));

            // Gem visningstider
            movieShowTimeRepo.saveAll(List.of(inceptionTime1, inceptionTime2, interstellarTime1, interstellarTime2));

            System.out.println("✅ Dummy data indsat i databasen!");
        };
    }
}
