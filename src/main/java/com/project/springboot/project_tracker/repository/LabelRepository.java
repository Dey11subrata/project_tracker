package com.project.springboot.project_tracker.repository;

import com.project.springboot.project_tracker.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Integer> {
}
