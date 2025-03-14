package org.example.kino_marts;

import org.example.kino_marts.model.Movie;
import org.example.kino_marts.model.MovieShow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import org.example.kino_marts.repository.MovieShowRepo;

@SpringBootTest
class KinoMartsApplicationTests {
	@Autowired
	MovieShowRepo movieShowRepo;

	@Test
	void contextLoads() {
		assertEquals(1,1);
	}

}
