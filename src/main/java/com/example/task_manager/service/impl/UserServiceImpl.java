package com.example.task_manager.service.impl;

import com.example.task_manager.domain.entity.User;
import com.example.task_manager.domain.repository.UserDetailRepository;
import com.example.task_manager.domain.repository.UserRepository;
import com.example.task_manager.model.mappers.UserMapper;
import com.example.task_manager.model.user.CreateUserDto;
import com.example.task_manager.model.user.UserDto;
import com.example.task_manager.service.UserService;
import com.example.task_manager.util.PasswordGenerator;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserDetailRepository userDetailRepository;
  private final UserMapper userMapper;
  private final PasswordGenerator passwordGenerator;
  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found"));
  }

  @Override
  public UserDto createUser(CreateUserDto userDto) {
    if (userRepository.existsByUsername(userDto.getUsername())) {
      throw new RuntimeException("Username already exists: " + userDto.getUsername());
    }
    if (userDetailRepository.existsByEmail(userDto.getEmail())) {
      throw new RuntimeException("Email already exists: " + userDto.getEmail());
    }

    User user = userMapper.createUserDtoToUser(userDto);
    user.setPassword(passwordEncoder.encode(passwordGenerator.generatePassword()));
    user = userRepository.save(user);
    return userMapper.toDto(user);
  }

  @Override
  public List<UserDto> getAllUsers() {
    return userRepository.findAll()
        .stream()
        .map(userMapper::toDto)
        .toList();
  }

  @Override
  public UserDto getUserById(Long id) {
    return userRepository.findById(id)
        .map(userMapper::toDto)
        .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
  }
}
