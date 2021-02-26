package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Location;

import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, Long> {
    Optional<Location> findLocationById(Long id);
}