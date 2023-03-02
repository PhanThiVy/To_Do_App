package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface UserRepository extends JpaRepository<User,Long> {
}
