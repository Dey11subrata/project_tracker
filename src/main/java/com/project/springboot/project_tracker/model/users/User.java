package com.project.springboot.project_tracker.model.users;

import com.project.springboot.project_tracker.constants.RoleName;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.SubTask;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private Integer id;

//    @Column(nullable = false)
    private String fullName;

//    @Column(unique = true, length = 100, nullable = false)
    private String email;

//    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
//    @Column(name = "updated_at")
    private LocalDate updatedAt;

//@Column(nullable = false)
    private RoleName roleName;

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Project> projects;

//    @OneToMany(mappedBy = "projectReporter", cascade = CascadeType.ALL)
//    private Set<Project> project;

    @ManyToMany(mappedBy = "epicAssignee", fetch = FetchType.EAGER)
    private Set<Epic> epics;

    @OneToOne(mappedBy = "epicReporter", cascade = CascadeType.ALL)
    private Epic epic;

    @OneToMany(mappedBy = "storyAssignee", cascade = CascadeType.ALL)
    private Set<Story> stories;

    @OneToOne(mappedBy = "storyReporter", cascade = CascadeType.ALL)
    private Story story;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "taskAssignee", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @OneToOne(mappedBy = "taskReporter", cascade = CascadeType.ALL)
    private Task task;

    @OneToMany(mappedBy = "bugAssignee", cascade = CascadeType.ALL)
    private Set<Bug> bugs;

    @OneToOne(mappedBy = "bugReporter", cascade = CascadeType.ALL)
    private Bug bug;

    @OneToMany(mappedBy = "subTaskAssignee", cascade = CascadeType.ALL)
    private Set<SubTask> subTasks;

    @OneToOne(mappedBy = "subTaskReporter", cascade = CascadeType.ALL)
    private SubTask subTask;

    /* overrides of methods of UserDetails interface of Spring security*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName.name());
        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}