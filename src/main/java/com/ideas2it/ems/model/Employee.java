package com.ideas2it.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *<p>
 * Class initialize all the Employee parameter inputs to a List
 * which holds all employees details and used to get and show all the details
 * of an employee.
 * </p>
 */
@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "projects")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 30, message = "Name should be 3 to 30 characters")
    @Column(name = "name")
    private String name;

    @Past
    @Column(name = "dob")
    private LocalDate dob;

    @NotNull(message = "Mobile number is mandatory")
    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number is 10 digits")
    @Column(name = "mobile_no")
    private String mobileNumber;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email should not valid")
    @NotBlank(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    @Column(name = "email_id")
    private String email;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_project",
               joinColumns = {@JoinColumn(name = "employee_id")},
               inverseJoinColumns = {@JoinColumn(name = "project_id")})

    private Set<Project> projects = new HashSet<>();
}
