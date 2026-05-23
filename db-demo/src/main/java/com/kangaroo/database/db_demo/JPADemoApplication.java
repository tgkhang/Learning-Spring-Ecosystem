package com.kangaroo.database.db_demo;

import com.kangaroo.database.db_demo.entity.PersonEntityJPA;
import com.kangaroo.database.db_demo.jdbc.PersonJdbcDao;
import com.kangaroo.database.db_demo.jpa.PersonJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JPADemoApplication implements CommandLineRunner {

	@Autowired
	PersonJPARepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PersonEntityJPA inserted = repository.insert(
				new PersonEntityJPA(0, "Tara", "Berlin", new java.util.Date()));
		log.info("Insert user -> {}", inserted);
		int generatedId = inserted.getId();
		log.info("Update user id {} -> {}", generatedId, repository.update(
				new PersonEntityJPA(generatedId, "Pieter", "Utrecht", new java.util.Date())));
		log.info("User id {} -> {}", generatedId, repository.findById(generatedId));

	}
}
