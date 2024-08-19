package com.ideas2it.ems.employee.service;

import com.ideas2it.ems.employee.dto.EmployeeDto;
import com.ideas2it.ems.model.Employee;

import java.util.List;

/**
 * <p>
 * EmployeeService defines the contract for the employee-related operations.
 * This includes CRUD operations and additional business logic.
 * </p>
 */
public interface EmployeeService {

    /**
     * <p>
     * Adds a new employee to the system.
     * </p>
     *
     * @param employeeDto The employee details.
     * @param departmentId The ID of the department to which the employee belongs.
     * @return The added EmployeeDto object.
     */
    EmployeeDto addEmployee(EmployeeDto employeeDto, int departmentId);

    /**
     * <p>
     * Retrieves all active employees.
     * </p>
     *
     * @return A list of EmployeeDto objects.
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * <p>
     * Retrieves an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee.
     * @return The EmployeeDto object of the retrieved employee.
     */
    EmployeeDto getEmployeeById(int id);

    /**
     * <p>
     * Updates an existing employee's details.
     * </p>
     *
     * @param employeeDto The employee details to update.
     * @param id The ID of the employee to update.
     * @return The updated EmployeeDto object.
     */
    EmployeeDto updateEmployee(EmployeeDto employeeDto, int id);

    /**
     * <p>
     * Removes an employee by setting their active status to false.
     * </p>
     *
     * @param id The ID of the employee to remove.
     */
    void removeEmployee(int id);

    /**
     * <p>
     * Adds a project to an employee.
     * </p>
     *
     * @param id The ID of the employee.
     * @param projectId The ID of the project to add.
     */
    void addProjectToEmployee(int id, int projectId);

    /**
     * <p>
     * Removes a project from an employee.
     * </p>
     *
     * @param id The ID of the employee.
     * @param projectId The ID of the project to remove.
     */
    void removeProjectFromEmployee(int id, int projectId);

    /**
     * <p>
     * Retrieves All the employees in a specific department.
     * </p>
     * @param departmentId The ID of the department.
     */
    List<EmployeeDto> getEmployeesByDepartment(int departmentId);

    /**
     * <p>
     * Retrieves All the employees in a specific project.
     * </p>
     *
     * @param projectId The ID of the project.
     */
    List<EmployeeDto> getEmployeesByProject(int projectId);

//    public boolean isEmailExists(String email);
}


