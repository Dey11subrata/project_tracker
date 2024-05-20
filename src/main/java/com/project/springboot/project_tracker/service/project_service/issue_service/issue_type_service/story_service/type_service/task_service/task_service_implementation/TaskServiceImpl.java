package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.task_service.task_service_implementation;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;
import com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story.type.TaskRepository;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.task_service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getListOfAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(int taskId) {
        return taskRepository.findById(taskId);
    }
}
