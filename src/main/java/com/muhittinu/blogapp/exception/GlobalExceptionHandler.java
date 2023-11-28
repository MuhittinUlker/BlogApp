package com.muhittinu.blogapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleRunTimeException(RuntimeException runtimeException){
        return ResponseEntity.ok(ErrorMessage.builder()
                        .code(9999)
                        .message("Beklenmeyen runtime hatasi "+runtimeException.getMessage())
                        .build());
    }

    @ExceptionHandler(BlogAppException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleDemoException(BlogAppException blogAppException){
        return ResponseEntity.status(blogAppException.getErrorType().getHttpStatus())
                .body(ErrorMessage.builder().code(blogAppException.getErrorType().getCode())
                        .message(blogAppException.getMessage()).build());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception){
        return ResponseEntity.ok(ErrorMessage.builder()
                .code(6666)
                .message("Degerler uyusmadi "+exception.getMessage())
                .build());
    }

}
