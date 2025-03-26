package com.example.demo.api.controller.exceptionHandler;

import com.example.demo.bll.exception.LaboException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(LaboException.class)
    public ResponseEntity<Object> handleLaboException (LaboException laboException){
        return ResponseEntity.status(laboException.getStatut()).body(laboException.getMessage());
    }
}
