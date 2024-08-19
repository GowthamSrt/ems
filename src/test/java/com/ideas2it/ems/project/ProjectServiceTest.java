package com.ideas2it.ems.project;

import com.ideas2it.ems.model.Project;
import com.ideas2it.ems.project.dao.ProjectRepository;
import com.ideas2it.ems.project.dto.ProjectDto;
import com.ideas2it.ems.project.service.ProjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    void testAddProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("Dynamo");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(1);
        projectDto.setName("Dynamo");
        when(projectRepository.save(any(Project.class))).thenReturn(project);
        ProjectDto createdProject = projectService.addProject(projectDto);
        assertEquals(projectDto.getName(), createdProject.getName());
        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testGetAllProjects() {
        Project project = new Project();
        project.setName("Dynamo");
        List<Project> projects = new ArrayList<>();
        projects.add(project);
        when(projectRepository.findAll()).thenReturn(projects);
        List<Project> result = new ArrayList<>();
        projectRepository.findAll().forEach(result :: add);
        assertEquals(projects, result);
    }

    @Test
    void testGetProjectById() {
        Project project = new Project();
        project.setId(1);
        project.setName("Dynamo");
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        Project result = projectRepository.findById(1).isPresent() ? projectRepository.findById(1).get() : null;
        assertEquals(project, result);
    }

    @Test
    void testDeleteProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("Hello");
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        projectService.deleteProject(1);
        verify(projectRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("Admin");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(1);
        projectDto.setName("Admin");
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        when(projectRepository.save(any(Project.class))).thenReturn(project);
        ProjectDto updatedProject = projectService.updateProject(projectDto, 1);
        assertNotNull(updatedProject);
        assertEquals("Admin", updatedProject.getName());
    }
}
