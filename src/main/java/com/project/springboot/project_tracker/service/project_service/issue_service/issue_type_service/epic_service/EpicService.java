package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.epic_service;

import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;

import java.util.List;

public interface EpicService {

    Epic createEpic(Epic epic);

    List<Epic> getListOfEpic();
}
