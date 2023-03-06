package com.example.ToDoApp.controller;

import com.example.ToDoApp.dto.requestDto.UserRequestDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import com.example.ToDoApp.exception.userException.UserNotValidException;
import com.example.ToDoApp.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Foos API", version = "v1"))
@SecurityRequirement(name = "basicAuth")
public class UserController {
    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );

            String errorMsg = "";

            for (String key : errors.keySet()) {
                errorMsg += "Error by: " + key + ", reason: " + errors.get(key) + " - ";
            }
            throw new UserNotValidException(HttpStatus.BAD_REQUEST.value(), errorMsg);
        }
        UserResponseDto userResponseDto = userService.addUser(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }
    @PostMapping("/addAdmin")
    public ResponseEntity<UserResponseDto> addAdmin(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.addAdmin(userRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

}
