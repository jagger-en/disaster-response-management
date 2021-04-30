package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.TeamEmployee;

public interface TeamEmployeeRepo extends JpaRepository<TeamEmployee, Long> {

}
