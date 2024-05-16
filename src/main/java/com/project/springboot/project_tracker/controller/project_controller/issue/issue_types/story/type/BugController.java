package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story.type;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.type.BugDto;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.bug_service.BugService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bug")
public class BugController {

    private BugService bugService;
    private ModelMapper modelMapper;

    @Autowired
    public BugController(BugService bugService, ModelMapper modelMapper) {
        this.bugService = bugService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Bug createBug(@RequestBody BugDto bugDto){
        Bug bugToCreate = modelMapper.map(bugDto, Bug.class);
        return bugService.createBug(bugToCreate);
    }

    @GetMapping("")
    public List<Bug> listOfAllBug(){
        return bugService.getListOfAllBug();
    }
}
