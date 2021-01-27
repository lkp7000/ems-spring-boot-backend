package com.gigatorb.ems.service;

import com.gigatorb.ems.exception.ResourceNotFoundException;
import com.gigatorb.ems.model.Employee;
import com.gigatorb.ems.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> getAllEmployees(){
        return employeeJpaRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeJpaRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        Employee employee  = employeeJpaRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exists with id "+id));
        return employee;
    }

    public Employee updateEmployee(Long id, Employee employeeDetails){
        Employee employee  = employeeJpaRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exists with id "+id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        return employeeJpaRepository.save(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeJpaRepository.delete(employee);
    }
}
