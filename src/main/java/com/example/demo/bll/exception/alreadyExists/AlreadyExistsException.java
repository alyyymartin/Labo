package com.example.demo.bll.exception.alreadyExists;

import com.example.demo.bll.exception.LaboException;

public class AlreadyExistsException extends LaboException {

    public AlreadyExistsException(String message) {
        super(message);
    };

    public AlreadyExistsException(String message, int statut) {
        super(message, statut);
    };
}


