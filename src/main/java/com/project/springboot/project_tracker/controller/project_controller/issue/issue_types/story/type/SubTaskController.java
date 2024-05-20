package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story.type;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type.SubTaskDto;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.SubTask;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.subtask_service.SubTaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sub_task")
public class SubTaskController {
    private SubTaskService subTaskService;
    private ModelMapper modelMapper;

    @Autowired
    public SubTaskController(SubTaskService subTaskService, ModelMapper modelMapper) {
        this.subTaskService = subTaskService;
        this.modelMapper = modelMapper;

    }

    @PostMapping("/create")
    public SubTask createSubTask(@RequestBody SubTaskDto subTaskDto){
        SubTask subTaskToCreate = modelMapper.map(subTaskDto, SubTask.class);
           return subTaskService.createSubTask(subTaskToCreate);
    }

    @GetMapping("")
    public List<SubTask> listOfAllSubTask(){
        return subTaskService.getAllSubTask();
    }
}
