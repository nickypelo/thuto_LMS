package com.nicodemus.thuto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class ThutoBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThutoBackendApiApplication.class, args);
	}

}
