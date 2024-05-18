package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story.type;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type.TaskDto;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Task;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.task_service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    private ModelMapper modelMapper;

    private ProjectService projectService;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper, ProjectService projectService) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody TaskDto taskDto,@RequestParam(name = "project-id", required = true) int projectId){
        Task taskToCreate = modelMapper.map(taskDto, Task.class);
        // find project
        Optional<Project> project = projectService.findAProjectById(projectId);
        // put in task if project exist
        if(project.isPresent()){
            taskToCreate.setProject(project.get());
        }
        return taskService.createTask(taskToCreate);
    }

    @GetMapping("")
    public List<Task> listOfAllTask(){
        return taskService.getListOfAllTask();
    }
}
