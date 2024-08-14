package com.ideas2it.ems.department.service;

import java.util.List;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.model.Department;
import org.springframework.stereotype.Service;

/**
 * <p>
 * DepartmentService defines the contract for the department-related operations.
 * This includes CRUD operations and additional business logic.
 * </p>
 */
@Service
public interface DepartmentService {
    /**
     * <p>
     * Adds a new department to the system.
     * </p>
     *
     * @param departmentDto The department details.
     * @return The added DepartmentDto object.
     */
    DepartmentDto addDepartment(DepartmentDto departmentDto);

    /**
     * <p>
     * Retrieves all active departments.
     * </p>
     *
     * @return A list of DepartmentDto objects.
     */
    List<DepartmentDto> getAllDepartments();

    /**
     * <p>
     * Retrieves an department by their ID.
     * </p>
     *
     * @param id The ID of the department.
     * @return The DepartmentDto object of the retrieved department.
     */
    public DepartmentDto getDepartmentById(int id);

    /**
     * <p>
     * Updates an existing department's details.
     * </p>
     *
     * @param departmentDto The department details to update.
     * @param id The ID of the department to update.
     * @return The updated DepartmentDto object.
     */
    DepartmentDto updateDepartment(DepartmentDto departmentDto, int id);

    /**
     * <p>
     * Removes an department by setting their active status to false.
     * </p>
     *
     * @param id The ID of the department to remove.
     */
    void deleteDepartment(int id);
}
