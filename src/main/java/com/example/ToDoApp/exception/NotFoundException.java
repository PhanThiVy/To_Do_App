package com.example.ToDoApp.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {
    private final ErrorDetail errorDetail;

    public NotFoundException(int errorCode,String message) {
        super(message);
        this.errorDetail = new ErrorDetail().builder()
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
