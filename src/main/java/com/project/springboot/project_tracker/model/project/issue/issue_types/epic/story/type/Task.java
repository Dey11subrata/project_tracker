package com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.model.users.User;
import lombok.Data;

import java.util.Set;

//@Entity
@Data
public class Task {
    private int taskId;
    private String taskName;
    private Project project;
    //    private IssueType  issueType;
    private Status taskStatus;
    private String taskSummary;
    private String taskDescription;
//    private Set<User> taskAssignee;
//    private Set<Label> taskLabels;
    //    private Epic epicParent;
    private int taskStoryPointEstimate;
//    private User taskReporter;


    //    @ManyToOne
    private Sprint sprint;
}
