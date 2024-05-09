package com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Bug;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Task;
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


    private Status storyStatus;
    private String storySummary;
    private String storyDescription;
    private int storyStoryPointEstimate;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User storyAssignee;

    @OneToOne
    private User storyReporter;

    @ManyToOne
    private Epic storyParent;

    @OneToMany(mappedBy = "taskParent", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "bugParent", cascade = CascadeType.ALL)
    private Set<Bug> bugs;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Label> storyLabels;
}
