package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

}