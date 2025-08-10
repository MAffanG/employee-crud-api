package com.thymeleaf.springboot.cruddemo.service;

import com.thymeleaf.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);

    boolean existsByEmailId(Employee theEmployee);

}
