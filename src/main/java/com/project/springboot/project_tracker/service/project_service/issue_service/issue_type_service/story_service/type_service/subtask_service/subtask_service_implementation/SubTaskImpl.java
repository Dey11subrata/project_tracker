package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.subtask_service.subtask_service_implementation;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.SubTask;
import com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story.type.SubTaskRepository;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.subtask_service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTaskImpl implements SubTaskService {

    private SubTaskRepository subTaskRepository;

    @Autowired
    public SubTaskImpl(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    @Override
    public SubTask createSubTask(SubTask subTask) {
        return subTaskRepository.save(subTask);
    }

    @Override
    public List<SubTask> getAllSubTask() {
        return subTaskRepository.findAll();
    }
}
