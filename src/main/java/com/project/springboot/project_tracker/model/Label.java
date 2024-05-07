package com.project.springboot.project_tracker.model;

import com.project.springboot.project_tracker.model.project.issue.Issue;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labelId;
    private String labelName;

    @ManyToMany(mappedBy = "labels", fetch = FetchType.EAGER)
    private List<Issue> issue;
}
