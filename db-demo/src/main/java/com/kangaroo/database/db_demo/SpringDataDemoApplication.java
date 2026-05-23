package com.kangaroo.database.db_demo;

import com.kangaroo.database.db_demo.entity.PersonEntityJPA;
import com.kangaroo.database.db_demo.jpa.PersonSpringDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class SpringDataDemoApplication implements CommandLineRunner {

    @Autowired
    PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // INSERT — Spring Data tự biết dùng persist() vì id=0
        PersonEntityJPA inserted = repository.save(new PersonEntityJPA(0, "Tara", "Berlin", new Date()));
        log.info("Inserted -> {}", inserted);

        int generatedId = inserted.getId();

        // UPDATE — Spring Data tự biết dùng merge() vì id đã tồn tại
        inserted.setName("Pieter");
        inserted.setLocation("Utrecht");
        PersonEntityJPA updated = repository.save(inserted);
        log.info("Updated -> {}", updated);

        // FIND BY ID
        log.info("Find id={} -> {}", generatedId, repository.findById(generatedId));

        // FIND ALL
        log.info("All persons -> {}", repository.findAll());

        // DELETE
        repository.deleteById(generatedId);
        log.info("After delete, all persons -> {}", repository.findAll());
    }
}
