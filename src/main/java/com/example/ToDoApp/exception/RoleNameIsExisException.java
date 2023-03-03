package com.example.ToDoApp.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RoleNameIsExisException extends RuntimeException{
    private final ErrorDetail errorDetail;

    public RoleNameIsExisException(int errorCode, String message) {
        super();
        this.errorDetail = new ErrorDetail().builder()
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
