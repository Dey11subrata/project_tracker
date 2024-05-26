package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.story_service_implementation;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.Story;
import com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story.StoryRepository;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public List<Story> getListOfAllStory() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<Story> findStoryById(int storyId) {
        return storyRepository.findById(storyId);
    }
}
