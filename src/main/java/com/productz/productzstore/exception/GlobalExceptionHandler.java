package com.productz.productzstore.exception;

import com.productz.productzstore.exception.user.ErrorCode;
import com.productz.productzstore.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<?> handleServiceException(ServiceException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        String message = errorCode.getMessage();
        if (exception instanceof UserNotFoundException) {
            UserNotFoundException userNotFoundException = (UserNotFoundException) exception;
            message = userNotFoundException.getMessage();
        }
        return new ResponseEntity<>(ExceptionResponse.builder().code(errorCode.getCode()).message(message).build(),
                HttpStatus.BAD_REQUEST);
    }
}
