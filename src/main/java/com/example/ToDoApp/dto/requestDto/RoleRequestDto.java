package com.example.ToDoApp.dto.requestDto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
