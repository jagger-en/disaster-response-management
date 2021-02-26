package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Gender;

import java.util.Optional;
public interface GenderRepo extends JpaRepository<Gender, Long> {
    Optional<Gender> findGenderById(Long id);
}
