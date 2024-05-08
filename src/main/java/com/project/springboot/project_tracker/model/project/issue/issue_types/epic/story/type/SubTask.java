package com.project.springboot.project_tracker.model.project.issue.issue_types.epic.story.type;

import com.project.springboot.project_tracker.constants.PriorityLevel;
import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subTaskId;
    private String subTaskName;
    private PriorityLevel subTaskPriority;
    private String subtaskDescription;
//    private Set<User> subTaskAssignee;
    private Status subTaskStatus;

}
