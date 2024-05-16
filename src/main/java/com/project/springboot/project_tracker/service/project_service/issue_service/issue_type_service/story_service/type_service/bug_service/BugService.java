package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.bug_service;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;

import java.util.List;

public interface BugService {

    Bug createBug(Bug bug);

    List<Bug> getListOfAllBug();
}
