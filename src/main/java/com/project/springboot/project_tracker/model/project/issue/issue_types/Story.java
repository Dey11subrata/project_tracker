package com.project.springboot.project_tracker.model.project.issue.issue_types;

import com.project.springboot.project_tracker.model.project.issue.Issue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Story extends Issue {
//    private Sprint sprint;
    private int storyPointEstimated;
}
