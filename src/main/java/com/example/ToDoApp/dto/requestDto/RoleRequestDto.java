package com.example.ToDoApp.dto.requestDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RoleRequestDto {
    @NotEmpty
    private String roleName;
}
