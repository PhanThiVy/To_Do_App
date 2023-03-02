package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Override
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public Page<RoleResponseDto> getRoleList(int pageNumber) {
        return null;
    }

    @Override
    public Role getRole(Long roleId) {
        return null;
    }

    @Override
    public RoleResponseDto getRoleById(Long roleId) {
        return null;
    }

    @Override
    public void deleteRole(Long roleId) {

    }

    @Override
    public RoleResponseDto editRole(Long roleId, RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public Page<RoleResponseDto> searchByRoleName(String roleName, int pageNumber) {
        return null;
    }

    @Override
    public void addBook(Role role, User user) {

    }

    @Override
    public void removeBook(Role role, User user) {

    }
}
