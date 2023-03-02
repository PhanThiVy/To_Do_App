package com.example.ToDoApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class role {
    @Id
    @GeneratedValue
    private Long id;
    private String roleName;

}
