package com.spring.data.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.data.model.Person;
import com.spring.data.repo.MutationPersonRepository;
import com.spring.data.repo.PersonRepository;

@Service
public record PersonService(PersonRepository personRepository, MutationPersonRepository mutationPersonRepository) {

    public List<Person> saveAll(){
        final Person john = new Person();
        john.setName("John");
        john.setAge(20);

        final Person tom = new Person();
        tom.setName("Tom");
        tom.setAge(10);

        return personRepository.saveAll(List.of(john, tom));
    }

    public List<Person> findPersonsByNameAndAge(final String name, final Integer age){
        return personRepository.findPersonsByNameAndAge(name, age);
    }

    public Integer updatePersonsName(final String oldName, final String newName){
        return mutationPersonRepository.updatePersonsName(oldName, newName);
    }

    public Integer deletePersonByName(final String name){
        return mutationPersonRepository.deletePersonByName(name);
    }
}
