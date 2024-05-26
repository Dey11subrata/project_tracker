package com.project.springboot.project_tracker.model.project.issue.issue_types.story.type;

import com.project.springboot.project_tracker.constants.PriorityLevel;
import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subTaskId;
    private String subTaskName;
    private PriorityLevel subTaskPriority;
    private String subtaskDescription;
    private Status subTaskStatus;

    @ManyToOne
    private User subTaskAssignee;

    @ManyToOne
    private Task subTaskParent;

    @OneToOne
    private User subTaskReporter;

}
