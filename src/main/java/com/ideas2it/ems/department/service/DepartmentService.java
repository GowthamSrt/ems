package com.ideas2it.ems.department.service;

import java.util.List;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.model.Department;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartments();

    public DepartmentDto getDepartmentById(int id);

    DepartmentDto updateDepartment(DepartmentDto departmentDto, int id);

    void deleteDepartment(int id);
}
