package com.spring.data.repo;

import org.springframework.stereotype.Repository;
import com.spring.data.model.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class MutationPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Integer updatePersonsName(String oldName, String newName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Person> criteriaUpdate = cb.createCriteriaUpdate(Person.class);
        Root<Person> root = criteriaUpdate.from(Person.class);
        criteriaUpdate.set(root.get("name"), newName);
        criteriaUpdate.where(cb.equal(root.get("name"), oldName));

        return entityManager.createQuery(criteriaUpdate).executeUpdate();
        
    }

    @Transactional
    public Integer deletePersonByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Person> criteriaDelete = cb.createCriteriaDelete(Person.class);
        Root<Person> root = criteriaDelete.from(Person.class);
        criteriaDelete.where(cb.equal(root.get("name"), name));

        return entityManager.createQuery(criteriaDelete).executeUpdate();
    }
}
