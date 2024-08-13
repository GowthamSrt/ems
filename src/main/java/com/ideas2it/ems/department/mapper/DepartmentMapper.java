package com.ideas2it.ems.department.mapper;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public static DepartmentDto mapDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    public static Department mapDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        return department;
    }
}
