package com.project.springboot.project_tracker.model.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    private String productOwner;
    private String projectManager;
    private String projectStatus;
    private String specialNotes;
    private LocalDate projectStartDate;
    private LocalDate projectEstimatedCompletionDate;
//    private LocalDate projectActualCompletionDate;
//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> user;

    @OneToOne
    private User projectReporter;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Epic> epics;


//    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Story> stories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Bug> bugs;
}
