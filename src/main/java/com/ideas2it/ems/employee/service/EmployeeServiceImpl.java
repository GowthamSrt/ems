package com.ideas2it.ems.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.ems.department.mapper.DepartmentMapper;
import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dao.EmployeeRepository;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.mapper.EmployeeMapper;
import com.ideas2it.ems.model.Department;
import com.ideas2it.ems.model.Employee;
import com.ideas2it.ems.project.service.ProjectService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;


    public EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId) {
        Employee employee = EmployeeMapper.mapEmployee(employeeDto);
        Department department = DepartmentMapper.mapDepartment(departmentService.getDepartmentById(departmentId));
        employee.setDepartment(department);
        return EmployeeMapper.mapEmployeeDto(employeeRepository.save(employee));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = new ArrayList<>();
        List<Employee> employeesActive = employeeRepository.findByIsActiveTrue();
        for (Employee employee : employeesActive) {
            employees.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        return employees;
    }

    public EmployeeDto getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findByIdAndIsActiveTrue(id);
        return EmployeeMapper.mapEmployeeDto(employee
                .orElseThrow(() -> new RuntimeException("Employee not found for ID: " + id)));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, int id) {
        Employee existingEmployee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setDob(employeeDto.getDob());
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setDepartment(DepartmentMapper.mapDepartment(departmentService.getDepartmentById(id)));
        return EmployeeMapper.mapEmployeeDto(employeeRepository.save(existingEmployee));
    }



    public void removeEmployee(int id) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        employee.setActive(false);
        employeeRepository.save(employee);
    }


    public void addProjectToEmployee(int id, int projectId) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        Project project = ProjectMapper.mapProject(projectService.getProjectById(projectId));
        employee.getProjects().add(project);
        employeeRepository.save(employee);
    }


    public void removeProjectFromEmployee(int id, int projectId) {
        Employee employee = EmployeeMapper.mapEmployee(getEmployeeById(id));
        Project project = ProjectMapper.mapProject(projectService.getProjectById(projectId));
        employee.getProjects().remove(project);
        employeeRepository.save(employee);
    }


    public List<EmployeeDto> getEmployeesByDepartment(int departmentId) {
        List<Employee> employees = employeeRepository.findByDepartmentIdAndIsActiveTrue(departmentId);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDtos.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        return employeeDtos;
    }


    public List<EmployeeDto> getEmployeesByProject(int projectId) {
        List<Employee> employees = employeeRepository.findByProjectIdAndIsActiveTrue(projectId);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            employeeDtos.add(EmployeeMapper.mapEmployeeDto(employee));
        }
        return employeeDtos;
    }
}