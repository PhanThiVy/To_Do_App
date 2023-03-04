package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.mapper.Mapper;
import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.exception.NotFoundException;
import com.example.ToDoApp.exception.RoleNameIsExisException;
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
        //check role name is exist or not
        roleNameIsExist(roleRequestDto.getRoleName());

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
    public Role getRole(String roleId) {
        //check roleId is a number
        if (isNumberic(roleId)) {
            Long id = Long.parseLong(roleId);
            //check role is exist
            Role role = roleRepository.findById(id).orElseThrow(()
                    -> new NotFoundException(HttpStatus.NOT_FOUND.value(),"Can not find role with id "+ roleId));
            return role;
        }
        //if roleId is not number , thrown NotFoundException
        throw new NotFoundException(HttpStatus.NOT_FOUND.value(),"Please enter number for role id.");


    }

    //method get a role by id
    @Override
    public RoleResponseDto getRoleById(String roleId) {
        Role role = getRole(roleId);
        return Mapper.roleToRoleResponseDto(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        Role role = roleRepository.findRoleByRoleName(roleName);
        return role;
    }

    //delete role by id
    @Override
    public void deleteRole(String roleId) {
        //check role is exist
        Role role = getRole(roleId);
        roleRepository.deleteById(role.getId());
        if (!role.getUsers().isEmpty()){
            for (User user: role.getUsers()) {
                removeUser(role,user);
            }
        }
    }

    //update role
    @Override
    public RoleResponseDto editRole(String roleId, RoleRequestDto roleRequestDto) {
        //check role is exist
        Role role = getRole(roleId);
        //check role name is exist or not
        roleNameIsExistForEdit(roleRequestDto.getRoleName(),role.getId());

        role.setRoleName(roleRequestDto.getRoleName());
        roleRepository.save(role);
        return Mapper.roleToRoleResponseDto(role);
    }

    @Override
    public Page<RoleResponseDto> searchByRoleName(String roleName, int pageNumber) {
        Page<Role> rolePage = roleRepository.findRoleByRoleNameContainingIgnoreCase(roleName,rolePageable.withPage(pageNumber));
        return rolePage.map(role -> modelMapper.map(role,RoleResponseDto.class));
    }

    @Override
    public void addUser(Role role, User user) {
        role.addUser(user);
        roleRepository.save(role);
    }

    @Override
    public void removeUser(Role role, User user) {
        role.removeUser(user);
        roleRepository.save(role);
    }

    @Override
    public boolean isNumberic(String roleId) {
        return NumberUtils.isCreatable(roleId);
    }

    @Override
    public void roleNameIsExist(String roleName) {
        Role role = roleRepository.findRoleByRoleName(roleName);
        if(role!=null){
            throw new RoleNameIsExisException(HttpStatus.CONFLICT.value(), " This role is exist - please enter a new one");
        }
    }

    @Override
    public void roleNameIsExistForEdit(String roleName,Long roleId) {
        Role role = roleRepository.roleNameIsExistForEdit(roleName,roleId);
        if(role!=null){
            throw new RoleNameIsExisException(HttpStatus.CONFLICT.value(), " This role is exist - please enter a new one");
        }
    }
}
