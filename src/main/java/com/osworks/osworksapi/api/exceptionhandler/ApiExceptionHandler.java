package com.osworks.osworksapi.api.exceptionhandler;

import java.time.LocalDateTime;

import com.osworks.osworksapi.api.exceptionhandler.Error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {

        Error error = new Error();

        error.setStatus(status.value());
        error.setTitle("Um ou mais campos estão inválidos." + "Tente novamente.");
        error.setDateTime(LocalDateTime.now());

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}