package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.AvailabilityStatus;

public interface AvailabilityStatusRepo extends JpaRepository<AvailabilityStatus, Long> {

}
