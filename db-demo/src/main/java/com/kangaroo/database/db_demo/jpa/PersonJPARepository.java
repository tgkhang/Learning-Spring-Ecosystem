package com.kangaroo.database.db_demo.jpa;

import com.kangaroo.database.db_demo.entity.PersonEntityJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonJPARepository {
    @PersistenceContext
    EntityManager em;

    public PersonEntityJPA findById(int id) {
        return em.find(PersonEntityJPA.class, id);
    }

    public PersonEntityJPA update(PersonEntityJPA person) {
        return em.merge(person);
    }

    public PersonEntityJPA insert(PersonEntityJPA person) {
        em.persist(person);
        return person;
    }

    public PersonEntityJPA deleteById(int id) {
        PersonEntityJPA person = findById(id);
        if (person != null) {
            em.remove(person);
        }
        return person;
    }
}
