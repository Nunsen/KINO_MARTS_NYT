package org.example.kino_marts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@SpringBootApplication
public class KinoMartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinoMartsApplication.class, args);
	}
}*/

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.kino_marts"}) // 📌 Scanner hele projektet
@EnableJpaRepositories(basePackages = "org.example.kino_marts.repository") // 📌 Scanner repositories
@EntityScan(basePackages = "org.example.kino_marts.model") // 📌 Scanner JPA entities!
public class KinoMartsApplication {
	public static void main(String[] args) {
		SpringApplication.run(KinoMartsApplication.class, args);
