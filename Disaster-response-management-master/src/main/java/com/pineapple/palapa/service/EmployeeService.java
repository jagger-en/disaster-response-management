package com.pineapple.palapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pineapple.palapa.exception.UserNotFoundException;
import com.pineapple.palapa.model.Employee;
import com.pineapple.palapa.repo.EmployeeRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public void deleteEmployee(Long id){
        Employee employee = employeeRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " was not found"));
        employeeRepo.delete(employee);
        // employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
            .orElseThrow(() -> new UserNotFoundException("Employee by id " + id + " was not found"));
    }

     public Employee updateEmployee(Employee employee) {
         return employeeRepo.save(employee);
     }

}
