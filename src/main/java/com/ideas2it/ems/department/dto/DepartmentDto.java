package com.ideas2it.ems.department.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * <p>
 * DepartmentDto is a Data Transfer Object that represents a Department.
 * It contains fields for transferring department-related data between layers of the application.
 * </p>
 */
@Data
public class DepartmentDto {

    @Valid
    private int id;

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 25, message = "Name should be 3 to 25 characters")
    private String name;
}
