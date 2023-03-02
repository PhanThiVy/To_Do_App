package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface RoleRepository extends JpaRepository<Role,Long> {
}
