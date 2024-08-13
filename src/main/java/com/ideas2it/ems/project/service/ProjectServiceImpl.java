package com.ideas2it.ems.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dao.ProjectRepository;
import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.project.mapper.ProjectMapper;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public ProjectDto addProject(ProjectDto projectDto) {
        Project project = ProjectMapper.mapProject(projectDto);
        return ProjectMapper.mapProjectDto(projectRepository.save(project));
    }

    public List<ProjectDto> getAllProjects() {
        List<ProjectDto> projects = new ArrayList<>();
        for (Project project : projectRepository.findAll()) {
            projects.add(ProjectMapper.mapProjectDto(project));
        }
        return projects;
    }

    public ProjectDto updateProject(ProjectDto projectDto, int id) {
        Project existingProject = ProjectMapper.mapProject(getProjectById(id));
        existingProject.setName(projectDto.getName());
        return ProjectMapper.mapProjectDto(projectRepository.save(existingProject));
    }

    public void deleteProject(int id) {
        Project project = ProjectMapper.mapProject(getProjectById(id));
        projectRepository.deleteById(id);
    }

    public ProjectDto getProjectById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            return ProjectMapper.mapProjectDto(project.get());
        }
        else {
            return null;
        }
    }
}
