package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story;

import com.project.springboot.project_tracker.constants.Status;
import lombok.Data;

@Data
public class StoryDto {
    private String storyName;
    private Status storyStatus;
    private String storySummary;
    private String storyDescription;
    private int storyStoryPointEstimate;
}
