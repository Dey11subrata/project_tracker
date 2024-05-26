package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story.type;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type.BugDto;
import com.project.springboot.project_tracker.exceptions.NoSuchBugFoundException;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.bug_service.BugService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bug")
public class BugController {

    private BugService bugService;
    private ModelMapper modelMapper;
    private ProjectService projectService;

    @Autowired
    public BugController(BugService bugService, ModelMapper modelMapper, ProjectService projectService) {
        this.bugService = bugService;
        this.modelMapper = modelMapper;
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public Bug createBug(@RequestBody BugDto bugDto, @RequestParam(name = "project-id") int projectId){
        Bug bugToCreate = modelMapper.map(bugDto, Bug.class);
        // find project
        Optional<Project> project = projectService.findAProjectById(projectId);

        if(project.isPresent()){
            bugToCreate.setProject(project.get());
        }
        return bugService.createBug(bugToCreate);
    }

    @GetMapping("/list-all")
    public List<Bug> listOfAllBug(){
        return bugService.getListOfAllBug();
    }

    // open a bug with id
    @GetMapping("")
    public BugDto openBugWithId(@RequestParam(name="bug-id") int bugId){
        Optional<Bug> bug = bugService.findBugWithId(bugId);
        if(bug.isPresent()){
            BugDto bugDto = modelMapper.map(bug.get(), BugDto.class);
            return bugDto;
        }
        throw new NoSuchBugFoundException("searched bug is not found....");
    }
}
