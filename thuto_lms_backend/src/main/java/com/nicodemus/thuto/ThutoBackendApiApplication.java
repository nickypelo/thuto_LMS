package com.nicodemus.thuto;

import com.nicodemus.thuto.model.Role;
import com.nicodemus.thuto.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class ThutoBackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThutoBackendApiApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(RoleRepository roleRepository){
//		return args -> {
//			if(roleRepository.findByName("USER").isEmpty()){
//				roleRepository.save(Role.builder().name("USER").build());
//			}
//		};
//	}
}
