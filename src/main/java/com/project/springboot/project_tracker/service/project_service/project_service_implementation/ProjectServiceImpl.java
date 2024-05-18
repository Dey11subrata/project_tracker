package com.project.springboot.project_tracker.service.project_service.project_service_implementation;

import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.repository.project_repository.ProjectRepository;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);

    }

    @Override
    public List<Project> getListOfAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findAProjectById(int id) {
        return projectRepository.findById(id);
    }
}
