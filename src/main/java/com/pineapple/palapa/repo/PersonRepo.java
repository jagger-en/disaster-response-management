package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
