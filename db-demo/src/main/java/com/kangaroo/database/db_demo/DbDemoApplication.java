package com.kangaroo.database.db_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kangaroo.database.db_demo.jdbc.PersonJdbcDao;

import lombok.extern.slf4j.Slf4j;

// @SpringBootApplication
@Slf4j
public class DbDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All user -> {}", dao.findAll());
		log.info("User id 10001 -> {}", dao.findById(10001));
		log.info("Delete user id 10002 -> No of rows deleted - {}", dao.deleteById(10002));
		log.info("Insert user id 10004 -> No of rows inserted - {}", dao.insert(
				new com.kangaroo.database.db_demo.entity.Person(10004, "Tara", "Berlin", new java.util.Date())));
	}
}
