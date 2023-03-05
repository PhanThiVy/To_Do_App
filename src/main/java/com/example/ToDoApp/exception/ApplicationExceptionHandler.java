package com.example.ToDoApp.exception;

import com.example.ToDoApp.exception.userException.NotFoundException;
import com.example.ToDoApp.exception.userException.UserNameExistException;
import com.example.ToDoApp.exception.userException.UserNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorDetail handlerNotFoundException(NotFoundException ex){
        return ex.getErrorDetail();
    }
    @ExceptionHandler(RoleNameIsExisException.class)
    public ErrorDetail handlerRuntimeException(RoleNameIsExisException ex){
        return ex.getErrorDetail();
    }
    @ExceptionHandler(UserNameExistException.class)
    public ErrorDetail handlerUserNameExistException(UserNameExistException ex){
        return ex.getErrorDetail();
    }
    @ExceptionHandler(UserNotValidException.class)
    public ErrorDetail handlerUserNotValidException(UserNameExistException ex){
        return ex.getErrorDetail();
    }
}

