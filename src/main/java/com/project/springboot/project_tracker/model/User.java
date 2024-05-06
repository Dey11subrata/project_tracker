package com.project.springboot.project_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "first name can not be left blank")
    private String firstName;

    @NotBlank(message = "last name can not be left blank")
    private String lastName;

    @NotBlank(message = "enter a valid Department Code")
    private String deptCode;

    @NotBlank(message = "role can not be left blank")
    private String role;

}
