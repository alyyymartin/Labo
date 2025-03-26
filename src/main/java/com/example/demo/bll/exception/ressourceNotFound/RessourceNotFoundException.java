package com.example.demo.bll.exception.ressourceNotFound;

import com.example.demo.bll.exception.LaboException;

public class RessourceNotFoundException extends LaboException {

    public RessourceNotFoundException(String message) {
        super(message);
    }

    public RessourceNotFoundException(String message, int statut) {
        super(message, statut);
    }
}
