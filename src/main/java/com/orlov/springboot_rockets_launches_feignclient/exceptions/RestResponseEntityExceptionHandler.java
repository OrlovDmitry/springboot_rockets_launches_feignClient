package com.orlov.springboot_rockets_launches_feignclient.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchRocketException.class)
    protected ResponseEntity<Object> handleConflict(
            Exception ex, WebRequest request){
        String bodyOfResponse = "Rocket with this ID has not been found";
        return handleExceptionInternal (ex, bodyOfResponse,
                new HttpHeaders (), HttpStatus.CONFLICT, request);
    }
}

