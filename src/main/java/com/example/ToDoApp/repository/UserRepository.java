package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUserNameIgnoreCase(String userName);
}
