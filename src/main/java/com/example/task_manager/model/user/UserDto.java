package com.example.task_manager.model.user;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserDto {
  private Long id;
  private String username;

  private String email;
  private String name;
  private String surname;
  private String info;
  private String phoneNumber;
  private LocalDateTime registerAt;

}