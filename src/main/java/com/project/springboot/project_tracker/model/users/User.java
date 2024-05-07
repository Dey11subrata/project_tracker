package com.project.springboot.project_tracker.model.users;

import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "first name can not be left blank")
    private String userFirstName;

    @NotBlank(message = "last name can not be left blank")
    private String userLastName;

    @NotBlank(message = "enter a valid Department Code")
    private String userDeptCode;

    @NotBlank(message = "role can not be left blank")
    private String userRole;

    @NotBlank(message = "email can not be left blank")
    @Email
    private String userEmail;

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Project> projects;

    @ManyToOne
    private Sprint sprint;


}
