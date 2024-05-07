package com.project.springboot.project_tracker.model.project.issue.issue_types;

import com.project.springboot.project_tracker.model.project.issue.Issue;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int storyPointEstimated;

    @ManyToOne
    private Sprint sprint;
}
