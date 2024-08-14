package com.ideas2it.ems.project.service;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dto.ProjectDto;

import java.util.List;

/**
 * <p>
 * ProjectService defines the contract for the project-related operations.
 * This includes CRUD operations and additional business logic.
 * </p>
 */
public interface ProjectService {
    /**
     * <p>
     * Adds a new project to the system.
     * </p>
     *
     * @param projectDto The project details.
     * @return The added ProjectDto object.
     */
    ProjectDto addProject(ProjectDto projectDto);

    /**
     * <p>
     * Retrieves all active projects.
     * </p>
     *
     * @return A list of ProjectDto objects.
     */
    List<ProjectDto> getAllProjects();

    /**
     * <p>
     * Updates an existing project's details.
     * </p>
     *
     * @param projectDto The project details to update.
     * @param id The ID of the project to update.
     * @return The updated ProjectDto object.
     */
    ProjectDto updateProject(ProjectDto projectDto, int id);

    /**
     * <p>
     * Removes an project by setting their active status to false.
     * </p>
     *
     * @param id The ID of the project to remove.
     */
    void deleteProject(int id);

    /**
     * <p>
     * Retrieves an project by their ID.
     * </p>
     *
     * @param id The ID of the project.
     * @return The ProjectDto object of the retrieved project.
     */
    ProjectDto getProjectById(int id);
}
