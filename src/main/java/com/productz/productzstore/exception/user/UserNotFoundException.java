package com.productz.productzstore.exception.user;

import com.productz.productzstore.exception.ServiceException;
import lombok.Getter;

@Getter
public class UserNotFoundException extends ServiceException {
    private String username;

    public UserNotFoundException(ErrorCode errorCode, String username) {
        super(errorCode);
        this.username = username;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " " + username;
    }
}
