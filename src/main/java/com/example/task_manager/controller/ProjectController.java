package com.example.task_manager.controller;

import com.example.task_manager.model.project.ProjectDto;
import com.example.task_manager.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("project", new ProjectDto());
    return "projects/create";
  }

  @PostMapping
  public String createUser(@ModelAttribute ProjectDto projectDto) {
    projectService.createProject(projectDto);
    return "redirect:/projects";
  }
}
