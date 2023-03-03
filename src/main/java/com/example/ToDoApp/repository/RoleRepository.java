package com.example.ToDoApp.repository;

import com.example.ToDoApp.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Page<Role> findAll(Pageable pageable);
    public Role findRoleByRoleNameIgnoreCase(String roleName);
    public Page<Role> findRoleByRoleNameContainingIgnoreCase(String roleName,Pageable pageable);
    @Query(value = "SELECT * FROM role r WHERE r.role_name = :roleName and r.id != :roleId", nativeQuery = true)
    Role roleNameIsExistForEdit(@Param("roleName") String roleName, @Param("roleId") Long roleId);
}
