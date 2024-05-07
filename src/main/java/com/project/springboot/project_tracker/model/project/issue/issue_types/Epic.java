package com.project.springboot.project_tracker.model.project.issue.issue_types;

import com.project.springboot.project_tracker.model.project.issue.Issue;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

//@Entity
@Data
public class Epic  {
    private LocalDate epicStartDate;
    private LocalDate epicDueDate;
}
