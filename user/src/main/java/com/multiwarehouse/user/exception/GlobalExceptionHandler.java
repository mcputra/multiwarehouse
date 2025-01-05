package com.multiwarehouse.user.exception;

import com.multiwarehouse.user.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> userAlreadyExistsException(
            UserAlreadyExistsException ex, WebRequest request) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

}
