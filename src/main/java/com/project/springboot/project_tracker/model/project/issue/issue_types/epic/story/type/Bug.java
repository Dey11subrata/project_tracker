package com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.Story;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bugId;

    private String bugName;

    //    private IssueType  issueType;
    private Status bugStatus;
    private String bugSummary;
    private String bugDescription;


    private int bugStoryPointEstimate;

    @OneToOne
        private User bugReporter;

    @ManyToOne
    private User bugAssignee;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Label> bugLabels;

    @ManyToOne
    private Story bugParent;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Sprint sprint;

}
