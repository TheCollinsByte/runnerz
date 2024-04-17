package com.collindigm.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runnerz {
	private static final Logger log = LoggerFactory.getLogger(Runnerz.class);

	public static void main(String[] args) {
		SpringApplication.run(Runnerz.class, args);
	}


	/*
	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "Warm-up", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
			runRepository.create(run);
			log.info("Run: {}", run);
		};
	}
	*/
}
