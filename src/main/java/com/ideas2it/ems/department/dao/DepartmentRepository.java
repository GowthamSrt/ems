package com.ideas2it.ems.department.dao;

import com.ideas2it.ems.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * DepartmentRepository is a DAO interface that extends the CrudRepository.
 * It provides CRUD operations and additional queries for Department entities.
 * </p>
 */
@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {


}