package com.ideas2it.ems.project.service;

import com.ideas2it.ems.model.Project;

import java.util.List;

public interface ProjectService {
    Project addProject(Project project);

    List<Project> getAllProjects();

    Project updateProject(Project project, int id);

    void deleteProject(int id);

    Project getProjectById(int id);
}
