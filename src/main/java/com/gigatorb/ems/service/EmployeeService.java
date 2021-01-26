package com.gigatorb.ems.service;

import com.gigatorb.ems.model.Employee;
import com.gigatorb.ems.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    public List<Employee> getAllEmployees(){
        return employeeJpaRepository.findAll();
    }
}
