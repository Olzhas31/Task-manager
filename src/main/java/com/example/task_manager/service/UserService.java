package com.example.task_manager.service;

import com.example.task_manager.model.user.CreateUserDto;
import com.example.task_manager.model.user.UserDto;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  UserDto createUser(CreateUserDto user);

  List<UserDto> getAllUsers();

  UserDto getUserById(Long id);
}
