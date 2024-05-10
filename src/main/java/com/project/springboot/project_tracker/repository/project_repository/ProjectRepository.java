package com.project.springboot.project_tracker.repository.project_repository;

import com.project.springboot.project_tracker.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
