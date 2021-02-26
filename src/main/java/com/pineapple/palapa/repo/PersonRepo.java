package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Optional<Person> findPersonById(Long id);
}
