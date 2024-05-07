package com.project.springboot.project_tracker.repository.user_repository;

import com.project.springboot.project_tracker.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
