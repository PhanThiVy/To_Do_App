package com.example.ToDoApp.controller;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceImpl roleService;
    @PostMapping("/add")
    public ResponseEntity<RoleResponseDto> addRole(@RequestBody RoleRequestDto roleRequestDto){
        RoleResponseDto roleResponseDto = roleService.addRole(roleRequestDto);
        return new ResponseEntity<>(roleResponseDto, HttpStatus.OK);
    }
    //get role list
    @GetMapping("/list")
    public ResponseEntity<Page<RoleResponseDto>> getRoleList(@RequestParam(defaultValue = "0") int pageNumber){
        Page<RoleResponseDto> roleResponseDtos = roleService.getRoleList(pageNumber);
        return new ResponseEntity<>(roleResponseDtos,HttpStatus.OK);
    }

    //get role by id
    @GetMapping("/getById/{roleId}")
    public ResponseEntity<RoleResponseDto> getRoleById(@PathVariable String roleId){
        RoleResponseDto roleResponseDto = roleService.getRoleById(roleId);
        return new ResponseEntity<>(roleResponseDto,HttpStatus.OK);
    }

    //detelete role by id
    @GetMapping("/delete/{roleId}")
    public ResponseEntity<Object> deleteRoleById(@PathVariable String roleId){
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }




}
