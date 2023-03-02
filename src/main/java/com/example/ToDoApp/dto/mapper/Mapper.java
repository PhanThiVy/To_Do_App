package com.example.ToDoApp.dto.mapper;

import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
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
        List<User> users = role.getUserList();
        for (User user: users) {
            userNames.add(user.getUsername());
        }
        roleResponseDto.setUserNames(userNames);

        return roleResponseDto;

    }
}
