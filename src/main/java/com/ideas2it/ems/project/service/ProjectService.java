package com.ideas2it.ems.project.service;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    ProjectDto addProject(ProjectDto projectDto);

    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(ProjectDto projectDto, int id);

    void deleteProject(int id);

    ProjectDto getProjectById(int id);
}
