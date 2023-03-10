package com.example.ToDoApp.exception.userException;

import com.example.ToDoApp.exception.ErrorDetail;
import lombok.*;

@RequiredArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private final ErrorDetail errorDetail;

    public NotFoundException(int errorCode, String message) {
        super();
        this.errorDetail = new ErrorDetail().builder()
                .errorCode(errorCode)
                .message(message)
                .build();
    }


}
