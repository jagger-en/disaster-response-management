package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.MissionAssignment;

public interface MissionAssignmentRepo extends JpaRepository<MissionAssignment, Long> {

}