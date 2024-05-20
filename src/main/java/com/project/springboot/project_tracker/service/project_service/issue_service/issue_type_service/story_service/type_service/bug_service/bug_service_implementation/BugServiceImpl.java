package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.bug_service.bug_service_implementation;

import com.project.springboot.project_tracker.model.project.issue.issue_types.story.type.Bug;
import com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.story.type.BugRepository;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.story_service.type_service.bug_service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {
    private BugRepository bugRepository;

    @Autowired
    public BugServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    @Override
    public Bug createBug(Bug bug) {
        return bugRepository.save(bug);
    }

    @Override
    public List<Bug> getListOfAllBug() {
        return bugRepository.findAll();
    }

    @Override
    public Optional<Bug> findBugWithId(int bugId) {
        return bugRepository.findById(bugId);
    }
}
