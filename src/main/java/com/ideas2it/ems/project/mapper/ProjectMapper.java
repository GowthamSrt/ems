package com.ideas2it.ems.project.mapper;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dto.ProjectDto;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public static ProjectDto mapProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        return projectDto;
    }

    public static Project mapProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setName(projectDto.getName());
        return project;
    }
}
