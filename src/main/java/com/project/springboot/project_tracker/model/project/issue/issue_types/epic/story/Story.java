package com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storyId;
    private String storyName;

    //    private IssueType  issueType;
    private Status storyStatus;
    private String storySummary;
    private String storyDescription;

    @ManyToOne
    private Project project;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> storyAssignee;
//    private Set<Label> storyLabels;
    //    private Epic storyParent;
    private int storyStoryPointEstimate;
//    private User storyReporter;


    @ManyToOne
    private Sprint sprint;
}
