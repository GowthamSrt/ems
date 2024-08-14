package com.ideas2it.ems.employee.controller;

import com.ideas2it.ems.department.service.DepartmentService;
import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.employee.service.EmployeeService;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * EmployeeController handles all incoming HTTP requests related to employees.
 * It interacts with the EmployeeService, DepartmentService, and ProjectService
 * to perform CRUD operations and manage the relationships between employees,
 * departments, and projects.
 * </p>
 */

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ProjectService projectService;

    /**
     * <p>
     * Adds a new employee into the database.
     *</p>
     *
     * @param employeeDto The employee data transfer object containing employee details.
     * @return The added EmployeeDto object.
     */
    @PostMapping("/employees")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto, employeeDto.getDepartmentId());
    }

    /**
     * <p>
     * Retrieves all active employees.
     * </p>
     *
     * @return A list of EmployeeDto objects.
     */
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * <p>
     * Retrieves an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee to retrieve.
     * @return The EmployeeDto object of the retrieved employee.
     */
    @GetMapping("/employees/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    /**
     * <p>
     * Updates an existing employee's details.
     * </p>
     *
     * @param employeeDto The employee data transfer object containing updated details.
     * @param id The ID of the employee to update.
     * @return The updated EmployeeDto object.
     */
    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return employeeService.updateEmployee(employeeDto, id);
    }

    /**
     * <p>
     * Removes an employee by setting their active status to false.
     * </p>
     *
     * @param id The ID of the employee to remove.
     */
    @DeleteMapping("/employees/delete/{id}")
    public void removeEmployee(@PathVariable int id) {
        employeeService.removeEmployee(id);
    }

    /**
     * <p>
     * Adds a project to an employee's list of projects.
     * </p>
     *
     * @param id The ID of the employee.
     * @param projectId The ID of the project to add.
     */
    @PostMapping("/employees/{id}/project/{projectId}")
    public void addProjectToEmployee(@PathVariable int id, @PathVariable int projectId) {
        employeeService.addProjectToEmployee(id, projectId);
    }

    /**
     * <p>
     * Removes a project from an employee's list of projects.
     * </p>
     *
     * @param id The ID of the employee.
     * @param projectId The ID of the project to remove.
     */
    @DeleteMapping("/employees/{id}/project/{projectId}")
    public void removeProjectFromEmployee(@PathVariable int id, @PathVariable int projectId) {
        employeeService.removeProjectFromEmployee(id, projectId);
    }

    /**
     * <p>
     * Displays employees by their department.
     * </p>
     *
     * @param id The ID of the department.
     * @return The EmployeeDto object for the employees in the department.
     */
    @GetMapping("/employees/department/{id}")
    public List<EmployeeDto> getEmployeeByDepartment(@PathVariable int id) {
        return employeeService.getEmployeesByDepartment(id);
    }

    /**
     * <p>
     * Displays employees by their project.
     * </p>
     *
     * @param id The ID of the project.
     * @return The EmployeeDto object for the employees in the project.
     */
    @GetMapping("/employees/project/{id}")
    public List<EmployeeDto> getEmployeeByProject(@PathVariable int id) {
        return employeeService.getEmployeesByProject(id);
    }
}
