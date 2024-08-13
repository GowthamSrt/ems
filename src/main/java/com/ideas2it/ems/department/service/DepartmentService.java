package com.ideas2it.ems.department.service;

import java.util.List;

import com.ideas2it.ems.model.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    Department addDepartment(Department department);

    List<Department> getAllDepartments();

    public Department getDepartmentById(int id);

    Department updateDepartment(Department department, int id);

    void deleteDepartment(int id);
}
