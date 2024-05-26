package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.subtask_service;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.SubTask;

import java.util.List;

public interface SubTaskService {

    SubTask createSubTask(SubTask subTask);

    List<SubTask> getAllSubTask();
}
