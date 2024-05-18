package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.EpicDto;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.epic_service.EpicService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/epic")
public class EpicController {

    private EpicService epicService;
    private ModelMapper modelMapper;
    private ProjectService projectService;



    @Autowired
    public EpicController(EpicService epicService, ModelMapper modelMapper, ProjectService projectService) {
        this.epicService = epicService;
        this.modelMapper = modelMapper;
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public Epic createEpic(@RequestBody EpicDto epicDto, @RequestParam(name = "project-id", required = true) int projectId){
//        projectId is required so that whenever an issue is created it got attached to some project.
        epicDto.setEpicStartDate(LocalDate.now());
        epicDto.setEpicDueDate(LocalDate.now().plusDays(12));

        // find a project
        Optional<Project> project = projectService.findAProjectById(projectId);



        Epic epicToCreate = modelMapper.map(epicDto, Epic.class);

        // map it with issue
        if(project.isPresent()){
//            epicDto.setProject(project.get());
            epicToCreate.setProject(project.get());
        }

log.info(epicDto.toString());
        return epicService.createEpic(epicToCreate);
    }

    @GetMapping("")
    public List<Epic> listOfAllEpic(){

        return epicService.getListOfEpic();
    }
}
