package com.project.springboot.project_tracker.model.project.issue;

import com.project.springboot.project_tracker.model.User;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Issue {
    private int issueId;
    private String issueName;
    private String issueStatus;
    private String issueSummary;
    private String issueDescription;
    private List<User> issueAssignee;
//    private List<labels> labels;
//    private Issue parent;
    private User reporter;
}
