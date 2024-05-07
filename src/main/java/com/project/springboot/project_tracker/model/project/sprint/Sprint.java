package com.project.springboot.project_tracker.model.project.sprint;

import com.project.springboot.project_tracker.model.project.issue.issue_types.Story;
import com.project.springboot.project_tracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sprintId;
    private String sprintName;
    private int sprintDuration;
    private LocalDate sprintStartDate;
    private LocalDate sprintEndDate;
    private String sprintGoal;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private Set<Story> stories;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<User> user;
}
