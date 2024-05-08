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
public class Bug {
    private int bugId;
    private String bugName;
    private Project project;
    //    private IssueType  issueType;
    private Status bugStatus;
    private String bugSummary;
    private String bugDescription;
//    private Set<User> bugAssignee;
//    private Set<Label> bugLabels;
    //    private Epic epicParent;
    private int bugStoryPointEstimate;
//    private User bugReporter;


    //    @ManyToOne
    private Sprint sprint;

}
