package com.project.springboot.project_tracker.repository.user_repository;

import com.project.springboot.project_tracker.constants.RoleEnum;
import com.project.springboot.project_tracker.model.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum roleEnum);
}
