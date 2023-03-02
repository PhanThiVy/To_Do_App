package com.example.ToDoApp.exception;

import lombok.Builder;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Builder
public class ErrorDetail {
    private int errorCode;
    private String mesage;
}
