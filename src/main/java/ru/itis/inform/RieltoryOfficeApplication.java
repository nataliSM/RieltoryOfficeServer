package ru.itis.inform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.inform.config.ApplicationDependenciesConfig;
import ru.itis.inform.config.JpaConfig;
import ru.itis.inform.config.SecurityConfig;

@SpringBootApplication
public class RieltoryOfficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {RieltoryOfficeApplication.class, JpaConfig.class, SecurityConfig.class, ApplicationDependenciesConfig.class}, args);
	}
}
