package com.spring.data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.data.model.Person;
import com.spring.data.service.PersonService;

@RestController
@RequestMapping("/person")
public record PersonController(PersonService personService) {

    @GetMapping("/save")
    public List<Person> savePerson(){
        return personService.saveAll();
    }

    @GetMapping("/find")
    public List<Person> findPersonByName(final String name, final Integer age){
        return personService.findPersonsByNameAndAge("John", 20);
    }

    @GetMapping("/update")
    public Integer updatePersonsName(final String name, final Integer age){
        return personService.updatePersonsName("John", "Saman");
    }

    @GetMapping("/delete")
    public Integer deletePersonByName(final String name){
        return personService.deletePersonByName("John");
    }

}
