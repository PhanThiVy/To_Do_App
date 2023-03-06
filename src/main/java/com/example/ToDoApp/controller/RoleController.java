package com.example.ToDoApp.controller;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.service.RoleServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
@RequestMapping("/role")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Foos API", version = "v1"))
@SecurityRequirement(name = "basicAuth")
public class RoleController {
    private final RoleServiceImpl roleService;
    @PostMapping("/add")
    public ResponseEntity<RoleResponseDto> addRole(@Valid @RequestBody RoleRequestDto roleRequestDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            bindingResult.get
        }
        RoleResponseDto roleResponseDto = roleService.addRole(roleRequestDto);
        return new ResponseEntity<>(roleResponseDto, HttpStatus.OK);
    }
    //get role list
    @GetMapping("/list")
    public ResponseEntity<Page<RoleResponseDto>> getRoleList(@RequestParam(defaultValue = "0") int pageNumber){
        Page<RoleResponseDto> roleResponseDtos = roleService.getRoleList(pageNumber);
        return new ResponseEntity<>(roleResponseDtos,HttpStatus.OK);
    }


    //detelete role by id
    @Transactional
    @GetMapping("/delete/{roleId}")
    public ResponseEntity<Object> deleteRoleById(@PathVariable String roleId){
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }







}
