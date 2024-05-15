package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story.type;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type.TaskDto;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.task_service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private ModelMapper modelMapper;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskDto taskDto){
        Task taskToCreate = modelMapper.map(taskDto, Task.class);
        return taskService.createTask(taskToCreate);
    }

    @GetMapping("")
    public List<Task> listOfAllTask(){
        return taskService.getListOfAllTask();
    }
}
