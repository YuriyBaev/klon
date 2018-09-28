package com.example.spring_data.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class DbApplication implements CommandLineRunner
{
	@Autowired
	StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Override
	public void run(String... args)
	{
		studentService.addStudent(new Student(10001L,"Bob", "123"));

		Optional<Student> student = studentService.findById(10001L);
		if (!student.isPresent())
		{
			LOG.debug("empty student");
			return;
		}

		LOG.debug("student id: {}, student name: {}, student passport: {}", student.get().getId(), student.get().getName(), student.get().getPassportNumber());

		LOG.debug("Get by name: {}", studentService.getByName("Bob"));

	}
}
