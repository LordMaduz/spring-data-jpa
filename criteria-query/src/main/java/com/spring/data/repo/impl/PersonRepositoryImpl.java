package com.spring.data.repo.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.data.model.Person;
import com.spring.data.repo.PersonRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findPersonsByNameAndAge(String name, Integer age) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);

        Root<Person> book = criteriaQuery.from(Person.class);
        Predicate namePredicate = cb.equal(book.get("name"), name);
        Predicate agePredicate = cb.equal(book.get("age"), age);
        criteriaQuery.where(namePredicate, agePredicate);

        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
