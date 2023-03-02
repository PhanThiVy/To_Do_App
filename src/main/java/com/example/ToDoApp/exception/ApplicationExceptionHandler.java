package com.example.ToDoApp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ErrorDetail handlerNotFoundException(NotFoundException ex){
        return ex.getErrorDetail();
    }

    }
