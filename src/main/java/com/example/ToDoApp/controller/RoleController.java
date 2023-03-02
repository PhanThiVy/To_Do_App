package com.example.ToDoApp.controller;

import com.example.ToDoApp.service.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleServiceImpl roleService;


}
