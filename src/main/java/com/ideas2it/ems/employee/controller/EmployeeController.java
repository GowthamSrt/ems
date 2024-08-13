package com.ideas2it.ems.employee.controller;

import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/employees")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto, employeeDto.getDepartmentId());
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    @DeleteMapping("/employees/delete/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }

    @PostMapping("/employees/addproject/{id}")
    public void addProjectToEmployee(@PathVariable int id, @RequestBody int projectId) {
        employeeService.addProjectToEmployee(id, projectId);
    }

    @DeleteMapping("employees/deleteproject/{id}")
    public void removeProjectFromEmployee(@PathVariable int id, @RequestBody int projectId) {
        employeeService.removeProjectFromEmployee(id, projectId);
    }
}
