package com.example.ToDoApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String roleName;
    @ManyToMany(mappedBy = "roles",cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            }, fetch = FetchType.LAZY)
    private List<User> users;
    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
