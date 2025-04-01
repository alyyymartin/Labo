package com.example.demo.api.controller.exceptionHandler;

import com.example.demo.bll.exception.LaboException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(LaboException.class)
    public ResponseEntity<String> handleLaboException (LaboException laboException){
        if (laboException.getStatut() == 500) {
            return new ResponseEntity<>(laboException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(laboException.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
