package com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.epic_service.epic_service_implementation;

import com.project.springboot.project_tracker.model.project.issue.issue_types.Epic;
import com.project.springboot.project_tracker.repository.project_repository.issue.issue_types.EpicRepository;
import com.project.springboot.project_tracker.service.project_service.issue_service.issue_type_service.epic_service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpicServiceImpl implements EpicService {

    private EpicRepository epicRepository;

    @Autowired
    public EpicServiceImpl(EpicRepository epicRepository) {
        this.epicRepository = epicRepository;
    }

    @Override
    public Epic createEpic(Epic epic) {
        return epicRepository.save(epic) ;
    }

    @Override
    public List<Epic> getListOfEpic() {
        return epicRepository.findAll();
    }

    @Override
    public Optional<Epic> findEpicById(int epicId) {
        return epicRepository.findById(epicId);
    }
}
