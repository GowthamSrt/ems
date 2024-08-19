package com.ideas2it.ems.employee.dao;

import com.ideas2it.ems.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * <p>
 * EmployeeRepository is a DAO interface that extends the CrudRepository.
 * It provides CRUD operations and additional queries for Employee entities.
 * </p>
 */

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    /**
     * Retrieves all active employees.
     *
     * @return A list of active employees.
     */
    List<Employee> findByIsActiveTrue();

    /**
     * Retrieves an active employee by their ID.
     *
     * @param id The ID of the employee.
     * @return The optional Employee object.
     */
    Optional<Employee> findByIdAndIsActiveTrue(int id);

    /**
     * Retrieves all active employees in a department.
     *
     * @param departmentId The ID of the employee.
     * @return The List of Employees.
     */
    @Query("from Employee e where e.department.id = :departmentId and e.isActive = true")
    List<Employee> findByDepartmentIdAndIsActiveTrue(@Param("departmentId") int departmentId);

    /**
     * Retrieves all active employees in a project.
     *
     * @param projectId The ID of the employee.
     * @return The List of Employees.
     */
    @Query("select e from Employee e join e.projects p where p.id = :projectId and e.isActive = true")
    List<Employee> findByProjectIdAndIsActiveTrue(@Param("projectId") int projectId);

//    @Query("from employee e left join e.projects p where e.id = :id")
//    Employee getProject;

    boolean existsByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);
}
