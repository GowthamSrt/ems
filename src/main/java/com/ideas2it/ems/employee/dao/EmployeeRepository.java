package com.ideas2it.ems.employee.dao;

import com.ideas2it.ems.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
