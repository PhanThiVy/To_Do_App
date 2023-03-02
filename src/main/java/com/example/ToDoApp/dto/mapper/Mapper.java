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
//        List<User> users = role.getUsers();
//        for (User user: users) {
//            userNames.add(user.getUserName());
//        }
        roleResponseDto.setUserNames(userNames);

        return roleResponseDto;

    }

    public static UserResponseDto userToUserResponseDto(User user){
        UserResponseDto userResponseDto =new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setUsername(user.getUserName());
        userResponseDto.setPassword(user.getPassword());

        List<String> roleNames = new ArrayList<>();
//        List<Role> roles = user.getRoles();
//        for (Role role: roles) {
//            roleNames.add(role.getRoleName());
//        }
        userResponseDto.setRoleNames(roleNames);

        return userResponseDto;

    }
}
