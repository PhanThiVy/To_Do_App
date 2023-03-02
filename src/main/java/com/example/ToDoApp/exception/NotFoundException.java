package com.example.Book.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {
    private int errorCode;

    public NotFoundException(int errorCode, String message) {

        super(message);
        this.errorCode=errorCode;
    }


}
