package com.example.ToDoApp.service;

import com.example.ToDoApp.dto.mapper.Mapper;
import com.example.ToDoApp.dto.requestDto.UserRequestDto;
import com.example.ToDoApp.dto.responseDto.UserResponseDto;
import com.example.ToDoApp.exception.userException.UserNameExistException;
import com.example.ToDoApp.model.User;
import com.example.ToDoApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
//    , UserDetailsService
    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";
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
        user.addRole(roleService.getRoleByName(UserServiceImpl.USER));
        //set mail
        user.setEmail(userRequestDto.getEmail());

        //save user
        userRepository.save(user);
        //save role
        roleService.addUser(roleService.getRoleByName(UserServiceImpl.USER),user);

        return Mapper.userToUserResponseDto(user);
    }

    @Override
    public UserResponseDto addAdmin(UserRequestDto userRequestDto) {
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
        user.addRole(roleService.getRoleByName(UserServiceImpl.ADMIN));
        //set mail
        user.setEmail(userRequestDto.getEmail());

        //save user
        userRepository.save(user);
        //save role
        roleService.addUser(roleService.getRoleByName(UserServiceImpl.ADMIN),user);

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
        User user = userRepository.findUserByUserName(userName);
        if (user != null) {
            throw new UserNameExistException(HttpStatus.CONFLICT.value(), " This user name is exist - please enter a new one");
        }
        return false;
    }


}
