package com.example.task_manager.controller;

import com.example.task_manager.model.user.CreateUserDto;
import com.example.task_manager.model.user.UserDto;
import com.example.task_manager.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("user", new CreateUserDto());
    return "users/create";
  }

  @PostMapping
  public String createUser(@ModelAttribute CreateUserDto user) {
    userService.createUser(user);
    return "redirect:/users";
  }

  @GetMapping("/{id}")
  public String getUserById(@PathVariable Long id, Model model) {
    UserDto userDto = userService.getUserById(id);
    model.addAttribute("user", userDto);
    return "users/view";
  }

  @GetMapping
  public String getAllUsers(Model model) {
    List<UserDto> users = userService.getAllUsers();
    model.addAttribute("users", users);
    return "users/list";
  }


}
