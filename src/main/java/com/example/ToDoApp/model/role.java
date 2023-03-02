package com.example.ToDoApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String roleName;

}
