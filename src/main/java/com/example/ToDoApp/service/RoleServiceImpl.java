package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.mapper.Mapper;
import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.exception.NotFoundException;
import com.example.ToDoApp.model.Role;
import com.example.ToDoApp.model.User;
import com.example.ToDoApp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    @Autowired
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

    //get role list
    @Override
    public Page<RoleResponseDto> getRoleList(int pageNumber) {
        Page<Role> rolePage = roleRepository.findAll(rolePageable.withPage(pageNumber));
        return rolePage.map(role -> modelMapper.map(role,RoleResponseDto.class));
    }

    @Override
    public boolean isNumberic(String roleId) {
        return NumberUtils.isCreatable(roleId);
    }

    @Override
    public Role getRole(String roleId) {
        //check roleId is a number
        if (isNumberic(roleId)) {
            Long id = Long.parseLong(roleId);
            Role role = roleRepository.findById(id).orElseThrow(()
                    -> new NotFoundException(HttpStatus.NOT_FOUND.value(),"Can not find role with id "+ roleId));
            return role;
        }
        throw new NotFoundException(HttpStatus.NOT_FOUND.value(),"Please enter number for role id.");


    }

    @Override
    public RoleResponseDto getRoleById(String roleId) {
        Role role = getRole(roleId);
        return Mapper.roleToRoleResponseDto(role);
    }

    @Override
    public void deleteRole(String roleId) {

    }

    @Override
    public RoleResponseDto editRole(String roleId, RoleRequestDto roleRequestDto) {
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
