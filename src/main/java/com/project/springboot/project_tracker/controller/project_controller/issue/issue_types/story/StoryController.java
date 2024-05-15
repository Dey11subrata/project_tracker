package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.StoryDto;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.StoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/story")
public class StoryController {
    private final StoryService storyService;
    private final ModelMapper modelMapper;

    @Autowired
    public StoryController(StoryService storyService, ModelMapper modelMapper) {
        this.storyService = storyService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public Story createStory(@RequestBody StoryDto storyDto) {
        Story storyToCreate = modelMapper.map(storyDto, Story.class);
        return storyService.createStory(storyToCreate);
    }

    @GetMapping("")
    public List<Story> listOfAllStories() {
        return storyService.getListOfAllStory();
    }
}
