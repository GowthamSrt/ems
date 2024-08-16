package com.ideas2it.ems.project.controller;

import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(projectService.addProject(projectDto), HttpStatus.CREATED);
    }

    /**
     * <p>
     * Retrieves all active projects.
     * </p>
     *
     * @return A list of ProjectDto objects.
     */
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
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
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") int id) {
        return new ResponseEntity<>(projectService.updateProject(projectDto, id), HttpStatus.ACCEPTED);
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
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("id") int id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }
}
