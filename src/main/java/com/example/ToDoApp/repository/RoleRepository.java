package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Page<Role> findAll(Pageable pageable);
}
