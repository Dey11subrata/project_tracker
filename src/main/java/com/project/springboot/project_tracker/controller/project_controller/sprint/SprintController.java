package com.project.springboot.project_tracker.controller.project_controller.sprint;

import com.project.springboot.project_tracker.dto.project_dto.sprint.SprintDto;
import com.project.springboot.project_tracker.model.project.sprint.Sprint;
import com.project.springboot.project_tracker.service.project_service.sprint_service.SprintService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {
    private SprintService sprintService;
    private ModelMapper modelMapper;

    @Autowired
    public SprintController(SprintService sprintService, ModelMapper modelMapper) {
        this.sprintService = sprintService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Sprint createSprint(@RequestBody SprintDto sprintDto){
        sprintDto.setSprintStartDate(LocalDate.now());
        sprintDto.setSprintEndDate(LocalDate.now().plusWeeks(sprintDto.getSprintDuration()));
        Sprint sprintToCreate = modelMapper.map(sprintDto, Sprint.class);
        return  sprintService.createSpring(sprintToCreate);
    }

    @GetMapping("")
    public List<Sprint> listOfAllSprint(){
        return sprintService.getListOfAllSprint();
    }
}
