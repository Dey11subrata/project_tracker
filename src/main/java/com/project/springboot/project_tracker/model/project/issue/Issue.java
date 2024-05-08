package com.project.springboot.project_tracker.model.project.issue;

import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Entity
//@Data
public class Issue {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int issueId;
    protected String issueName;
    protected String issueStatus;
    protected String issueSummary;
    protected String issueDescription;
//    private List<User> issueAssignee;
//    many-to-many relationship
//    private Issue parent;
//    private User reporter;

//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    protected List<Label> labels;

//    @ManyToOne
//    protected Project project;
}
