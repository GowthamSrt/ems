package com.ideas2it.ems.employee.dto;

import com.ideas2it.ems.model.Department;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private int id;

    private String name;

    private LocalDate dob;

    private String mobileNumber;

    private String email;

    private int departmentId;

    private String departmentName;

    private int projectId;
}
