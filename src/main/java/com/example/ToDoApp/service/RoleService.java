package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;
import org.springframework.data.domain.Page;

public interface RoleService {
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto);
    public Page<RoleResponseDto> getRoleList(int pageNumber);
    public Role getRole(Long roleId);
    public RoleResponseDto getRoleById(Long roleId);
    public void deleteRole(Long roleId);
    public RoleResponseDto editRole(Long roleId, RoleRequestDto roleRequestDto);
    public Page<RoleResponseDto> searchByRoleName(String roleName,int pageNumber);
    void addBook(Role role, User user);
    void removeBook(Role role, User user);
}
