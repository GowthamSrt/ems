package com.ideas2it.ems.project.service;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dao.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    public Project updateProject(Project project, int id) {
        Project existingProject = projectRepository.findById(id).get();
        if (Objects.nonNull(project.getName()) && !"".equalsIgnoreCase(project.getName())) {
            existingProject.setName(project.getName());
        }
        return projectRepository.save(existingProject);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

    public Project getProjectById(int id) {
        return (projectRepository.findById(id).isPresent() ? projectRepository.findById(id).get() : null);
    }
}
