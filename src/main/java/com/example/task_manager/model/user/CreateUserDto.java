package com.example.task_manager.model.user;

import lombok.Data;

@Data
public class CreateUserDto {

  private String username;
  private String email;
  private String name;
  private String surname;
  private String info;
  private String phoneNumber;

}
