package com.study.studyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

public class StudyspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyspringApplication.class, args);
	}

}
