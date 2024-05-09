package com.project.springboot.project_tracker.model.project.issue.issue_types.story.type;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String taskName;

    //    private IssueType  issueType;
    private Status taskStatus;
    private String taskSummary;
    private String taskDescription;


    private int taskStoryPointEstimate;

    @OneToOne
    private User taskReporter;

    @ManyToOne
    private User taskAssignee;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Label> taskLabels;

    @ManyToOne
    private Story taskParent;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "subTaskParent", cascade = CascadeType.ALL)
    private Set<SubTask> subTasks;
}
