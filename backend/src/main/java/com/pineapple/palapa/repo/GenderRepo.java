package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Gender;

public interface GenderRepo extends JpaRepository<Gender, Long> {

}