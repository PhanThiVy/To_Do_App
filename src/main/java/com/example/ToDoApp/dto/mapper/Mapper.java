package com.example.ToDoApp.dto.mapper;

import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static RoleResponseDto roleToRoleResponseDto(Role role){
        RoleResponseDto roleResponseDto =new RoleResponseDto();

        roleResponseDto.setId(role.getId());
        roleResponseDto.setRoleName(role.getRoleName());

        List<String> userNames = new ArrayList<>();
        List<User> users = role.getUsers();
        for (User user: users) {
            userNames.add(user.getUserName());
        }
        roleResponseDto.setUserNames(userNames);

        return roleResponseDto;

    }

    public static List<RoleResponseDto> authorsToAuthorResponseDtos(List<Role> roles){
        List<RoleResponseDto> roleResponseDtos= new ArrayList<>();
        for (Role role: roles) {
            roleResponseDtos.add(roleToRoleResponseDto(role));
        }
        return roleResponseDtos;
    }

    public static UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto =new UserResponseDto();

        userResponseDto.setId(user.getId());
        userResponseDto.setFullName(user.getFullName());
        userResponseDto.setUserName(user.getUserName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setRegistrationDate(user.getRegistrationDate());
        userResponseDto.setLocked(user.getLocked());
        userResponseDto.setEnabled(user.getEnabled());
        List<String> roleNames = new ArrayList<>();
        List<Role> roles = user.getRoles();
        for (Role role: roles) {
            roleNames.add(role.getRoleName());
        }
        userResponseDto.setRoleNames(roleNames);

        return userResponseDto;

    }
}
