package co.edu.unbosque.Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * The main class that starts the Task application.
 */
@SpringBootApplication
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*" })
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

	}

}
