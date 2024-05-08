package com.project.springboot.project_tracker.model.project.issue.issue_types.epic;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int epicId;
    private String epicName;

    //private IssueType issueType;
    private Status epicStatus;
    private String epicSummary;
    private String epicDescription;

//    private Set<Label> epicLabels;
    //    private Epic epicParent;
    private LocalDate epicStartDate;
    private LocalDate epicDueDate;
//    private User epicReporter;

    @ManyToOne
    private Project project;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> epicAssignee;

}
