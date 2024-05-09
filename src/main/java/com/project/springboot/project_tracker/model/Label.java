package com.project.springboot.project_tracker.model;

import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.Story;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Bug;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int labelId;
    private String labelName;

    @ManyToMany(mappedBy = "epicLabels", fetch = FetchType.EAGER)
    private Set<Epic> epics;

    @ManyToMany(mappedBy = "storyLabels", fetch = FetchType.EAGER)
    private Set<Story> stories;

    @ManyToMany(mappedBy = "taskLabels", fetch = FetchType.EAGER)
    private Set<Task> tasks;

    @ManyToMany(mappedBy = "bugLabels", fetch = FetchType.EAGER)
    private Set<Bug> bugs;

//    @ManyToMany(mappedBy = "labels", fetch = FetchType.EAGER)
//    private List<Issue> issue;
}
