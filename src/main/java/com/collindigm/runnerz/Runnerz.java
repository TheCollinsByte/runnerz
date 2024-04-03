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
		log.info("Runnerz Server Started Successfully");
	}
}
