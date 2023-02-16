package com.productz.productzstore.exception;

import com.productz.productzstore.exception.user.ErrorCode;
import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    protected ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        // todo kakwo she stane ako mahna supera
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
