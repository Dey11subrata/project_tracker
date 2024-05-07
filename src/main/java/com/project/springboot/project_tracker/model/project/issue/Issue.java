package com.project.springboot.project_tracker.model.project.issue;

import com.project.springboot.project_tracker.model.Label;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int issueId;
    private String issueName;
    private String issueStatus;
    private String issueSummary;
    private String issueDescription;
//    private List<User> issueAssignee;
//    many-to-many relationship
//    private Issue parent;
//    private User reporter;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Label> labels;

    @ManyToOne
    private Project project;
}
