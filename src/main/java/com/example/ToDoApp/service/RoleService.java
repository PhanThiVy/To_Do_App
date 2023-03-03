package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;
import org.springframework.data.domain.Page;

public interface RoleService {
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto);
    public Page<RoleResponseDto> getRoleList(int pageNumber);
    public Role getRole(String roleId);
    public RoleResponseDto getRoleById(String roleId);
    public void deleteRole(String roleId);
    public RoleResponseDto editRole(String roleId, RoleRequestDto roleRequestDto);
    public Page<RoleResponseDto> searchByRoleName(String roleName,int pageNumber);
    void addUser(Role role, User user);
    void removeUser(Role role, User user);
    public boolean isNumberic(String roleId);
    public void roleNameIsExist(String roleName);
    public void roleNameIsExistForEdit(String roleName,Long roleId);
}
