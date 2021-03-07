package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.City;

import java.util.Optional;

public interface CityRepo extends JpaRepository<City, Long> {
    Optional<City> findCityById(Long id);
}