package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.EpicDto;
import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.epic_service.EpicService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/epic")
public class EpicController {

    private EpicService epicService;
    private ModelMapper modelMapper;

    @Autowired
    public EpicController(EpicService epicService, ModelMapper modelMapper) {
        this.epicService = epicService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Epic createEpic(@RequestBody EpicDto epicDto, @RequestParam int projectId){
//        projectId is required so that whenever an issue is created it got attached to some project.
epicDto.setEpicStartDate(LocalDate.now());
epicDto.setEpicDueDate(LocalDate.now().plusDays(12));
        Epic epicToCreate = modelMapper.map(epicDto, Epic.class);
log.info(epicDto.toString());
        return epicService.createEpic(epicToCreate);
    }

    @GetMapping("")
    public List<Epic> listOfAllEpic(){

        return epicService.getListOfEpic();
    }
}
