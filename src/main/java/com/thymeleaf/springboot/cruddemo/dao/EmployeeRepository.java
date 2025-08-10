package com.thymeleaf.springboot.cruddemo.dao;

import com.thymeleaf.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code!


    List<Employee> findAllByOrderByLastNameAsc();

    boolean existsByEmail(String Email);

    // Spring Data JPA will automatically parse the method name,
    // detect the predefined keyword pattern, and generate the appropriate query at runtime.
}
