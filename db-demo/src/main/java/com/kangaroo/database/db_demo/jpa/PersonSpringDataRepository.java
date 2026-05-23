package com.kangaroo.database.db_demo.jpa;

import com.kangaroo.database.db_demo.entity.PersonEntityJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<PersonEntityJPA, Integer> {
}