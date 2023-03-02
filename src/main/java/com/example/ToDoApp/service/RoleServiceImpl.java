package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.mapper.Mapper;
import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;
import com.example.ToDoApp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private PageRequest rolePageable;
    public final ModelMapper modelMapper = new ModelMapper();

    //add a new role
    @Override
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto) {
        Role role = new Role();
        role.setRoleName(roleRequestDto.getRoleName());
        //save role
        roleRepository.save(role);
        return Mapper.roleToRoleResponseDto(role);
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
