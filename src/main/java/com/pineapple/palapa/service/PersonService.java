package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Person;
import com.pineapple.palapa.repo.PersonRepo;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person addPerson(Person Person) {
        return personRepo.save(Person);
    }

    public List<Person> findAllPersons() {
        return personRepo.findAll();
    }

    public void deletePerson(Long id){
        Person person = personRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Person by id " + id + " was not found"));
        personRepo.delete(person);
    }
}
