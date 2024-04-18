package com.collindigm.runnerz;

import com.collindigm.runnerz.run.JdbcClientRunRepository;
import com.collindigm.runnerz.run.Location;
import com.collindigm.runnerz.run.Run;
import com.collindigm.runnerz.user.User;
import com.collindigm.runnerz.user.UserHttpClient;
import com.collindigm.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Runnerz {
	private static final Logger LOG = LoggerFactory.getLogger(Runnerz.class);

	public static void main(String[] args) {
		SpringApplication.run(Runnerz.class, args);
	}


	/*
	@Bean
	CommandLineRunner runner(JdbcClientRunRepository runRepository) {
		return args -> {
			Run run = new Run(1, "Warm-up", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR, 1);
			runRepository.create(run);
			log.info("Run: {}", run);
		};
	}
	*/

	@Bean
	UserHttpClient userHttpClient() {
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}

	@Bean
	CommandLineRunner user(UserHttpClient httpClient, UserRestClient restClient) {
		return args -> {
			List<User> users = httpClient.findAll();
			LOG.info("List of users via HTTP Client: {}", users);

			User user = restClient.findById(1);
			LOG.info("Fetch User via REST Client: {}", users);
		};
	}
}
