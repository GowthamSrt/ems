package com.ideas2it.ems.department.mapper;

import com.ideas2it.ems.department.dto.DepartmentDto;
import com.ideas2it.ems.model.Department;
import org.springframework.stereotype.Component;

/**
 * <p>
 * DepartmentMapper is responsible for converting between Department entities and DepartmentDto objects.
 * It helps in mapping entity objects to DTOs and vice versa.
 * </p>
 */
@Component
public class DepartmentMapper {
    /**
     * <p>
     * Maps an Department entity to an DepartmentDto.
     * </p>
     *
     * @param department The Department entity to map.
     * @return The mapped DepartmentDto object.
     */
    public static DepartmentDto mapDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    /**
     * <p>
     * Maps an DepartmentDto to an Department entity.
     * </p>
     *
     * @param departmentDto The DepartmentDto to map.
     * @return The mapped Department entity.
     */
    public static Department mapDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        return department;
    }
}
