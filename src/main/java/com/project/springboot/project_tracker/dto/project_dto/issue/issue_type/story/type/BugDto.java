package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type;

import com.project.springboot.project_tracker.constants.Status;
import lombok.Data;

@Data
public class BugDto {
    private String bugName;
    private Status bugStatus;
    private String bugSummary;
    private String bugDescription;
    private int bugStoryPointEstimate;
}
