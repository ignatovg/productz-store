package com.productz.productzstore.exception.user;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_NOT_FOUND(10001, "User Not Found"),
    USERNAME_ALREADY_TAKEN(10002, "Username already taken");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
