package com.project.springboot.project_tracker.dto.project_dto.issue.issue_type;

import com.project.springboot.project_tracker.constants.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor@AllArgsConstructor
public class EpicDto {

    private String epicName;


    private Status epicStatus;
    private String epicSummary;
    private String epicDescription;


    //    private Epic epicParent;
    private LocalDate epicStartDate;
    private LocalDate epicDueDate;
}
