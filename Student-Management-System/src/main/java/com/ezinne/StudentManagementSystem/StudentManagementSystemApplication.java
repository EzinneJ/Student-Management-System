package com.ezinne.StudentManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentManagementSystemApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			 Student student1 = new Student("Chidi", "Ezinne", "Chidi@gmail.com");
			 studentRepository.save(student1);

			 Student student2 = new Student("Joy", "Chidi", "joy@gmail.com");
			 studentRepository.save(student2);

			 Student student3 = new Student("Eby", "Nwa", "ebyy@gmail.com");
			 studentRepository.save(student3);
		};

	}

}
