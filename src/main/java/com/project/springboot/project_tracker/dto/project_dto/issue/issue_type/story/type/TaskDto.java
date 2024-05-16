package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type;

import com.project.springboot.project_tracker.constants.Status;
import lombok.Data;

@Data
public class TaskDto {

    private String taskName;
    private Status taskStatus;
    private String taskSummary;
    private String taskDescription;
    private int taskStoryPointEstimate;
}
