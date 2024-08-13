package com.ideas2it.ems.employee.controller;

import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.service.EmployeeService;
import com.ideas2it.ems.mapper.Mapper;
import com.ideas2it.ems.model.Employee;
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

    @PostMapping("/employee")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return Mapper.mapEmployeeDto(employeeService.addEmployee(Mapper.mapEmployee(employeeDto), employeeDto.getDepartmentId()));
    }

    @GetMapping("/employee")
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            employees.add(Mapper.mapEmployeeDto(employee));
        }
        return employees;
    }


    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return Mapper.mapEmployeeDto(employeeService.getEmployeeById(id));
    }



    @PutMapping("/employee/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return Mapper.mapEmployeeDto(employeeService.updateEmployee(Mapper.mapEmployee(employeeDto), id));
    }

    @PutMapping("/employee/delete/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }

    @PostMapping("/employee/addproject/{id}")
    public void addProjectToEmployee(@PathVariable int id, @RequestBody int projectId) {
        employeeService.addProjectToEmployee(id, projectId);
    }
    
}
