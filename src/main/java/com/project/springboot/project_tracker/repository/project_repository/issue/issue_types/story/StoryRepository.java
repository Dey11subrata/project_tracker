package com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Integer> {
}
