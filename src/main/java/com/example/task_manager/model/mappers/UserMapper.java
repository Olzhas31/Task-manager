package com.example.task_manager.model.mappers;

import com.example.task_manager.model.user.CreateUserDto;
import com.example.task_manager.model.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.example.task_manager.domain.entity.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "userDetail.email", source = "email")
  @Mapping(target = "userDetail.name", source = "name")
  @Mapping(target = "userDetail.surname", source = "surname")
  @Mapping(target = "userDetail.info", source = "info")
  @Mapping(target = "userDetail.phoneNumber", source = "phoneNumber")
  @Mapping(target = "locked", constant = "false")
  @Mapping(target = "enabled", constant = "false")
  @Mapping(target = "role", constant = "employee")
  User createUserDtoToUser(CreateUserDto dto);

  @Mapping(source = "userDetail.email", target = "email")
  @Mapping(source = "userDetail.name", target = "name")
  @Mapping(source = "userDetail.surname", target = "surname")
  @Mapping(source = "userDetail.info", target = "info")
  @Mapping(source = "userDetail.phoneNumber", target = "phoneNumber")
  @Mapping(source = "userDetail.registerAt", target = "registerAt")
  UserDto toDto(User user);

}
