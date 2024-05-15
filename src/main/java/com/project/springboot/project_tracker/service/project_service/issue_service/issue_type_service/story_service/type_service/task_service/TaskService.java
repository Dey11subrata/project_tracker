package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.task_service;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    List<Task> getListOfAllTask();
}
