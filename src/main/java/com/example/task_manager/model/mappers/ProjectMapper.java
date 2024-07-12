package com.example.task_manager.model.mappers;

import com.example.task_manager.domain.entity.Project;
import com.example.task_manager.model.project.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {

  Project toEntity(ProjectDto projectDto);

  ProjectDto toDto(Project project);
}
