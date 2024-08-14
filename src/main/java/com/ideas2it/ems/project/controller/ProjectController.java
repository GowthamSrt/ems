package com.ideas2it.ems.project.controller;

import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * ProjectController handles all incoming HTTP requests related to projects.
 * It interacts with the ProjectService, DepartmentService, and ProjectService
 * to perform CRUD operations and manage the relationships between projects,
 * departments, and projects.
 * </p>
 */

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    /**
     * <p>
     * Adds a new project into the database.
     *</p>
     *
     * @param projectDto The project data transfer object containing project details.
     * @return The added ProjectDto object.
     */
    @PostMapping("/projects")
    @RequestMapping("api/v1")
    public ProjectDto addProject(@RequestBody ProjectDto projectDto){
        return projectService.addProject(projectDto);
    }

    /**
     * <p>
     * Retrieves all active projects.
     * </p>
     *
     * @return A list of ProjectDto objects.
     */
    @GetMapping("/projects")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    /**
     * <p>
     * Updates an existing project's details.
     * </p>
     *
     * @param projectDto The project data transfer object containing updated details.
     * @param id The ID of the project to update.
     * @return The updated ProjectDto object.
     */
    @PutMapping("/projects/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") int id) {
        return projectService.updateProject(projectDto, id);
    }

    /**
     * <p>
     * Removes an project by setting their active status to false.
     * </p>
     *
     * @param id The ID of the project to remove.
     */
    @DeleteMapping("/projects/{id}")
    public void deleteProject (@PathVariable("id") int id) {
        projectService.deleteProject(id);
    }

    /**
     * <p>
     * Retrieves an project by their ID.
     * </p>
     *
     * @param id The ID of the project to retrieve.
     * @return The ProjectDto object of the retrieved project.
     */
    @GetMapping("/projects/{id}")
    public ProjectDto getProjectById(@PathVariable("id") int id) {
        return projectService.getProjectById(id);
    }
}
