package com.ideas2it.ems.project.dto;

import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * ProjectDto is a Data Transfer Object that represents a Project.
 * It contains fields for transferring project-related data between layers of the application.
 * </p>
 */
@Data
public class ProjectDto {
    private int id;

    private String name;

}
