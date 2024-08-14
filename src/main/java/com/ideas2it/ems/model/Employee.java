package com.ideas2it.ems.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "mobile_no")
    private String mobileNumber;

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
