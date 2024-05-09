package com.project.springboot.project_tracker.repository.project_repository.issue.issue_types;

import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic, Integer> {
}
