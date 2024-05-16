package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type;

import com.project.springboot.project_tracker.constants.PriorityLevel;
import com.project.springboot.project_tracker.constants.Status;
import lombok.Data;

@Data
public class SubTaskDto {
    private String subTaskName;
    private PriorityLevel subTaskPriority;
    private String subtaskDescription;
    private Status subTaskStatus;
}
