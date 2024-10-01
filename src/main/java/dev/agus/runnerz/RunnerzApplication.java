package dev.agus.runnerz;

import dev.agus.runnerz.run.Location;
import dev.agus.runnerz.run.Run;
import dev.agus.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			log.info("Creating runs");
			runRepository.create(new Run(1, "Morning Run", LocalDateTime.now().minus(1, ChronoUnit.HOURS), LocalDateTime.now(), 5, Location.OUTDOOR));
			runRepository.create(new Run(2, "Evening Run", LocalDateTime.now().minus(2, ChronoUnit.HOURS), LocalDateTime.now(), 10, Location.INDOOR));
			runRepository.create(new Run(3, "Afternoon Run", LocalDateTime.now().minus(3, ChronoUnit.HOURS), LocalDateTime.now(), 15, Location.INDOOR));
			runRepository.create(new Run(4, "Night Run", LocalDateTime.now().minus(4, ChronoUnit.HOURS), LocalDateTime.now(), 20, Location.OUTDOOR));
			runRepository.create(new Run(5, "Midnight Run", LocalDateTime.now().minus(5, ChronoUnit.HOURS), LocalDateTime.now(), 25, Location.INDOOR));
		};
	}
}
