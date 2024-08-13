package com.ideas2it.ems.project.controller;

import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.mapper.Mapper;
import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/project")
    public ProjectDto addProject(@RequestBody ProjectDto projectDto){
        return Mapper.mapProjectDto(projectService.addProject(Mapper.mapProject(projectDto)));
    }

    @GetMapping("/project")
    public List<ProjectDto> getAllProjects() {
        List<ProjectDto> projects = new ArrayList<>();
        for (Project project : projectService.getAllProjects()) {
            projects.add(Mapper.mapProjectDto(project));
        }
        return projects;
    }

    @PutMapping("/project/{id}")
    public ProjectDto updateProject(@RequestBody ProjectDto projectDto, @PathVariable("id") int id) {
        return Mapper.mapProjectDto(projectService.updateProject(Mapper.mapProject(projectDto), id));
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject (@PathVariable("id") int id) {
        projectService.deleteProject(id);
        return "Project Deleted Successfully";
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable("id") int id) {
        return Mapper.mapProjectDto(projectService.getProjectById(id));
    }
    
}
