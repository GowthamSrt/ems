package com.ideas2it.ems.department.dto;

import lombok.Data;

/**
 * <p>
 * DepartmentDto is a Data Transfer Object that represents a Department.
 * It contains fields for transferring department-related data between layers of the application.
 * </p>
 */
@Data
public class DepartmentDto {

    private int id;

    private String name;
}
