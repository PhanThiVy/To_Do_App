package com.example.ToDoApp.exception.userException;

import com.example.ToDoApp.exception.ErrorDetail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserNameExistException extends RuntimeException{
    private final ErrorDetail errorDetail;

    public UserNameExistException(int errorCode, String message) {
        super();
        this.errorDetail = new ErrorDetail().builder()
                .errorCode(errorCode)
                .message(message)
                .build();
    }
}
