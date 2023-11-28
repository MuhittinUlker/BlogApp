package com.muhittinu.blogapp.exception;

import lombok.Getter;

@Getter
public class BlogAppException extends RuntimeException{
    private final ErrorType errorType;
    public BlogAppException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }
    public BlogAppException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

}
