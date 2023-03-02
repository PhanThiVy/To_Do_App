package com.example.ToDoApp.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserRequestDto {
    @NotEmpty
    @Size(min = 5,max = 60)
    private String username;

    @NotEmpty
    @Size(min = 8,max = 20)
    private String password;

    @NotEmpty
    @Email
    private String email;
}
