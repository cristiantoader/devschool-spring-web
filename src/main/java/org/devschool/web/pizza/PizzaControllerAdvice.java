package org.devschool.web.pizza;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.I_AM_A_TEAPOT;

@ControllerAdvice
public class PizzaControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException() {
        return new ResponseEntity("Whoops", I_AM_A_TEAPOT);
    }
}
