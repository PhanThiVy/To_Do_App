package com.example.ToDoApp.controller;

import com.example.ToDoApp.dto.requestDto.UserRequestDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import com.example.ToDoApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("add")
    public ResponseEntity<UserResponseDto> addUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
}
