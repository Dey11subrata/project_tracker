package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type;

import com.project.springboot.project_tracker.constants.Status;
import com.project.springboot.project_tracker.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpicDto {

    private String epicName;
    private Status epicStatus;
    private String epicSummary;
    private String epicDescription;
    private LocalDate epicStartDate;
    private LocalDate epicDueDate;
    private Project project;
    //    private Epic epicParent;
}
