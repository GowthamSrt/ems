package com.ideas2it.ems.project.controller;

import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public ProjectDto addProject(@RequestBody ProjectDto projectDto){
        return projectService.addProject(projectDto);
    }

    @GetMapping("/project")
    public List<ProjectDto> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/project/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") int id) {
        return projectService.updateProject(projectDto, id);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProject (@PathVariable("id") int id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable("id") int id) {
        return projectService.getProjectById(id);
    }
}
