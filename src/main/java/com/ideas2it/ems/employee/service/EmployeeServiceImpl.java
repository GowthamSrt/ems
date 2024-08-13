package com.ideas2it.ems.employee.service;

import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dao.EmployeeRepository;
import com.ideas2it.ems.model.Employee;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;


    public Employee addEmployee(Employee employee, int departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return (employeeRepository.findById(id).isPresent() ? employeeRepository.findById(id).get() : null);
    }

    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employee.getName());
        existingEmployee.setDob(employee.getDob());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }

    public void removeEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employee.setActive(false);
        employeeRepository.save(employee);
    }

    public void addProjectToEmployee(int id, int projectId) {
        Employee employee = getEmployeeById(id);
        employee.getProjects().add(projectService.getProjectById(projectId));
        employeeRepository.save(employee);

    }
}

