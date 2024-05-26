package com.project.springboot.project_tracker.controller.project_controller.issue.issue_types.story;

import com.project.springboot.project_tracker.dto.project_dto.issue.issue_type.story.StoryDto;
import com.project.springboot.project_tracker.exceptions.NoSuchStoryFoundException;
import com.project.springboot.project_tracker.model.project.Project;
import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.service.project_service.ProjectService;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.StoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/story")
public class StoryController {
    private final StoryService storyService;
    private final ModelMapper modelMapper;
    private ProjectService projectService;

    @Autowired
    public StoryController(StoryService storyService, ModelMapper modelMapper, ProjectService projectService) {
        this.storyService = storyService;
        this.modelMapper = modelMapper;
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public Story createStory(@RequestBody StoryDto storyDto, @RequestParam(name = "project-id", required = true) int projectId) {
        Story storyToCreate = modelMapper.map(storyDto, Story.class);
        // find the project
        Optional<Project> project = projectService.findAProjectById(projectId);
       if(project.isPresent()){

           storyToCreate.setProject(project.get());
       }

        return storyService.createStory(storyToCreate);
    }

    @GetMapping("/list-all")
    public List<Story> listOfAllStories() {
        return storyService.getListOfAllStory();
    }

  // attach an epic with existing story


    // open a Story with an Id
    @GetMapping("")
    public StoryDto openStoryWithId(@RequestParam(value = "story-id") int storyId){
        Optional<Story> story = storyService.findStoryById(storyId);
        if(story.isPresent()){
            StoryDto storyDto = modelMapper.map(story.get(), StoryDto.class);
            return storyDto;
        }

        throw new NoSuchStoryFoundException("searched story not found");
    }
}
