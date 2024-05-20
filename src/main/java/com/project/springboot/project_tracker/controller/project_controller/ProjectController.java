package com.project.springboot.project_tracker.controller.project_controller;

import com.project.springboot.project_tracker.dto.project_dto.ProjectDto;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.utility.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectController(ProjectService projectService, ModelMapper modelMapper) {
        this.projectService = projectService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Response> createNewProject(@RequestBody ProjectDto projectDto) {
        Response response = new Response();
        projectDto.setProjectStartDate(LocalDate.now());
        projectDto.setProjectEstimatedCompletionDate(LocalDate.now().plusDays(15));
        Project project = modelMapper.map(projectDto, Project.class);

        Project createdProject = projectService.createProject(project);

        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setMessage("Project details saved");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("project_created", "true")
                .body(response);
    }


    @GetMapping("")
    public List<Project> listOfAllProject(@RequestParam(name = "page-number", defaultValue ="0") int pageNumber,
                                          @RequestParam(name="page-size", defaultValue = "2") int pageSize) {

        return projectService.getListOfAllProject(pageNumber, pageSize);
    }
}
