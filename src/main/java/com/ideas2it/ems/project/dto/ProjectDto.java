package com.ideas2it.ems.project.dto;

import com.ideas2it.ems.model.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

/**
 * <p>
 * ProjectDto is a Data Transfer Object that represents a Project.
 * It contains fields for transferring project-related data between layers of the application.
 * </p>
 */
@Data
public class ProjectDto extends Project {
    private int id;

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")
    @Size(min = 3, max = 25, message = "Name should be 3 to 25 characters")
    private String name;

}
