package com.project.springboot.project_tracker.service.project_service.sprint_service.sprint_service_implementation;

import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.repository.project_repository.sprint.SprintRepository;
import com.project.springboot.project_tracker.service.project_service.sprint_service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    private SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Sprint createSpring(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public List<Sprint> getListOfAllSprint() {
        return sprintRepository.findAll();
    }
}
