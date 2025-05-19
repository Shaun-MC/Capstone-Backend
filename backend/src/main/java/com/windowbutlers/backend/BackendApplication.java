package com.windowbutlers.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Possible Optimization for all Update requests:
/*
 * You can use a custom repository method or a JPQL (Java Persistence Query Language) to update query to directly update the [ANY] field for the given
 * ID. This avoids loading the entire Job entity into memory, which can improve performance, especially if the Job entity is large.
 */

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
