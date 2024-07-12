package com.example.task_manager.service.impl;

import com.example.task_manager.domain.entity.Project;
import com.example.task_manager.domain.repository.ProjectRepository;
import com.example.task_manager.model.mappers.ProjectMapper;
import com.example.task_manager.model.project.ProjectDto;
import com.example.task_manager.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  @Override
  public ProjectDto createProject(ProjectDto projectDto) {
    if (projectRepository.existsByName(projectDto.getName())) {
      throw new RuntimeException("Project name already exists: " + projectDto.getName());
    }
    Project project = projectRepository.save(projectMapper.toEntity(projectDto));
    return projectMapper.toDto(project);
  }
}
