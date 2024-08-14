package com.ideas2it.ems.employee.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * EmployeeDto is a Data Transfer Object that represents an Employee.
 * It contains fields for transferring employee-related data between layers of the application.
 * </p>
 */
@Data
public class EmployeeDto {
    private int id;

    private String name;

    private LocalDate dob;

    private String mobileNumber;

    private String email;

    private int departmentId;

    private String departmentName;

    private List<Integer> projectIds;
}
