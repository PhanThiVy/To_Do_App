package com.example.ToDoApp.dto.requestDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RoleRequestDto {
    @NotEmpty
    @Size(min = 3,max = 20)
    private String roleName;
}
