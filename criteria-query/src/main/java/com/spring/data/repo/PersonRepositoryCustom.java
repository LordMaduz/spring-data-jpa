package com.spring.data.repo;

import java.util.List;

import com.spring.data.model.Person;

public interface PersonRepositoryCustom {
    List<Person> findPersonsByNameAndAge(String name, Integer age);

}

