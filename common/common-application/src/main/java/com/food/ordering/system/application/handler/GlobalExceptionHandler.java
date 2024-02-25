package com.food.ordering.system.application.handler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Unexpected error");
    }

    @ResponseBody
    @ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDTO handleException(ValidationException validationException) {
        ErrorDTO errorDTO;
        if (validationException instanceof ConstraintViolationException constraintViolationException){
            String violations= extractViolationsFromException(constraintViolationException);
            log.error(violations, constraintViolationException);
            errorDTO= new ErrorDTO(HttpStatus.BAD_REQUEST.getReasonPhrase(), violations);
        } else {
            log.error(validationException.getMessage(),validationException);
            errorDTO= new ErrorDTO(HttpStatus.BAD_REQUEST.getReasonPhrase(), validationException.getMessage())
        }
        return  errorDTO;
    }

    private String extractViolationsFromException(ConstraintViolationException constraintViolationException) {
    return constraintViolationException.getConstraintViolations()
            .stream().map(ConstraintViolation::getMessage)
            .collect(Collectors.joining("--"));
    }
}
