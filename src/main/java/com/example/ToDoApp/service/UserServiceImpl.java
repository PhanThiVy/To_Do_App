package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.mapper.Mapper;
import com.example.ToDoApp.dto.requestDto.UserRequestDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import com.example.ToDoApp.exception.UserNameExistException;
import com.example.ToDoApp.model.User;
import com.example.ToDoApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String ROLE = "USER";
    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        //set full name
        user.setFullName(userRequestDto.getFullName());
        //check and set user name
        if (!userNameIsExist(userRequestDto.getUserName())) {
            user.setUserName(userRequestDto.getUserName());
        }

        //set password
        String encodedPassword = passwordEncoder.encode(userRequestDto.getPassword());
        user.setPassword(encodedPassword);
        user.addRole(roleService.getRoleByName(UserServiceImpl.ROLE));
        //set mail
        user.setEmail(userRequestDto.getEmail());

        //save user
        userRepository.save(user);
        //save role
        roleService.addUser(roleService.getRoleByName(UserServiceImpl.ROLE),user);

        return Mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto addRoleToUserToUser(String userId, String roleId) {
        return null;
    }

    @Override
    public UserResponseDto deleteRoleFromUser(String bookId, String roleId) {
        return null;
    }

    @Override
    public boolean isNumberic(String userId) {
        return false;
    }

    @Override
    public boolean userNameIsExist(String userName) {
        User user = userRepository.findUserByUserNameIgnoreCase(userName);
        if (user != null) {
            throw new UserNameExistException(HttpStatus.CONFLICT.value(), " This user name is exist - please enter a new one");
        }
        return false;
    }


}
