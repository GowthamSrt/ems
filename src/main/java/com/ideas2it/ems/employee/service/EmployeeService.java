package com.ideas2it.ems.employee.service;

import com.ideas2it.ems.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee, int departmentId);


    List<Employee> getAllEmployees();


    Employee getEmployeeById(int id);


    Employee updateEmployee(Employee employee, int id);

    void addProjectToEmployee(int id, int projectId);

    void removeEmployee(int id);

}


