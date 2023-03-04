package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.requestDto.UserRequestDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserResponseDto addUser(UserRequestDto userRequestDto);
    public UserResponseDto addRoleToUserToUser(String userId, String roleId);
    public UserResponseDto deleteRoleFromUser(String bookId, String roleId);
    public boolean isNumberic(String userId);
    public boolean userNameIsExist(String userName);

}
