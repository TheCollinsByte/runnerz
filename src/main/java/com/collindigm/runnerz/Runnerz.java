package com.collindigm.runnerz;

import com.collindigm.runnerz.run.Location;
import com.collindigm.runnerz.run.Run;
import com.collindigm.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Runnerz {
	private static final Logger log = LoggerFactory.getLogger(Runnerz.class);

	public static void main(String[] args) {
		SpringApplication.run(Runnerz.class, args);
	}


	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "Warm-up", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
			runRepository.create(run);
			log.info("Run: {}", run);
		};
	}
}
