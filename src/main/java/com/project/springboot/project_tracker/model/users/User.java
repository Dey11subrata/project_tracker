package com.project.springboot.project_tracker.model.users;

import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.Story;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Bug;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.SubTask;
import com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type.Task;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "first name can not be left blank")
    private String userFirstName;

    @NotBlank(message = "last name can not be left blank")
    private String userLastName;

    @NotBlank(message = "enter a valid Department Code")
    private String userDeptCode;

    @NotBlank(message = "role can not be left blank")
    private String userRole;

    @NotBlank(message = "email can not be left blank")
    @Email
    private String userEmail;

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Project> projects;

    @OneToOne(mappedBy = "projectReporter", cascade = CascadeType.ALL)
    private Project project;

    @ManyToMany(mappedBy = "epicAssignee", fetch = FetchType.EAGER)
    private Set<Epic> epics;

    @OneToOne(mappedBy = "epicReporter", cascade = CascadeType.ALL)
    private Epic epic;

    @OneToMany(mappedBy = "storyAssignee", cascade = CascadeType.ALL)
    private Set<Story> stories;

    @OneToOne(mappedBy = "storyReporter", cascade = CascadeType.ALL)
    private Story story;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "taskAssignee", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @OneToOne(mappedBy = "taskReporter", cascade = CascadeType.ALL)
    private Task task;

    @OneToMany(mappedBy = "bugAssignee", cascade = CascadeType.ALL)
    private Set<Bug> bugs;

    @OneToOne(mappedBy = "bugReporter", cascade = CascadeType.ALL)
    private Bug bug;

    @OneToMany(mappedBy = "subTaskAssignee", cascade = CascadeType.ALL)
    private Set<SubTask> subTasks;

    @OneToOne(mappedBy = "subTaskReporter", cascade = CascadeType.ALL)
    private SubTask subTask;


}
