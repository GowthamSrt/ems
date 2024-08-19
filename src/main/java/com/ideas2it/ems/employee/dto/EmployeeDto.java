package com.ideas2it.ems.employee.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * EmployeeDto is a Data Transfer Object that represents an Employee.
 * It contains fields for transferring employee-related data between layers of the application.
 * </p>
 */
@Data
public class EmployeeDto {
    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 30, message = "Name should be 3 to 30 characters")
    private String name;

    @Past(message = "Enter a valid date of birth")
    private LocalDate dob;

    @NotNull(message = "Mobile number is mandatory")
    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number is 10 digits")
    private String mobileNumber;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email should not valid")
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    private String email;

    private int departmentId;

    private String departmentName;

    private String age;
}
