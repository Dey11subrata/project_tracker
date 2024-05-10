package com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story.type;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, Integer> {
}
