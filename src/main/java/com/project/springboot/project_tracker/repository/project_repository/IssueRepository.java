package com.project.springboot.project_tracker.repository.project_repository;

import com.project.springboot.project_tracker.model.project.issue.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
