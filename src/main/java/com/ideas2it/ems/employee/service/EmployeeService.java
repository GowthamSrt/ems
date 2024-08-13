package com.ideas2it.ems.employee.service;

import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.model.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(int id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    void addProjectToEmployee(int id, int projectId);

    void removeProjectFromEmployee(int id, int projectId);

    void removeEmployee(int id);
}


