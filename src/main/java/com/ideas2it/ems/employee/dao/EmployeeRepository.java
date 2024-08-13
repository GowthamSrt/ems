package com.ideas2it.ems.employee.dao;

import com.ideas2it.ems.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByIsActiveTrue();

    Optional<Employee> findByEmployeeIdAndIsActiveTrue(int id);
}
