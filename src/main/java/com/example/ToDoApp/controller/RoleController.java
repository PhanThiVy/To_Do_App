package com.example.ToDoApp.controller;

import com.example.ToDoApp.dto.requestDto.RoleRequestDto;
import com.example.ToDoApp.dto.responseDto.RoleResponseDto;
import com.example.ToDoApp.service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
