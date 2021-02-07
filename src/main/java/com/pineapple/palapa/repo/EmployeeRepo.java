package com.pineapple.palapa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pineapple.palapa.model.Employee;

// import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Optional<Employee> findEmployeeById(Long id);
    // void deleteEmployeeById(Long id);
}
