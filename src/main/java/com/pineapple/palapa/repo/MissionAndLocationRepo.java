package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionAndLocation;

public interface MissionAndLocationRepo extends JpaRepository<MissionAndLocation, Long> {

}