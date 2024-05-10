package com.project.springboot.project_tracker.repository.project_repository.sprint;

import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Integer> {
}
