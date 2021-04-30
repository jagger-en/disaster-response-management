package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
