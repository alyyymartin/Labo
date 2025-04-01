package com.example.demo.api.model.joueur.DeleteByUsername;

import com.example.demo.dal.domain.entity.Joueur;

public record DeleteJoueurByUsernameResponse(
        String message,
        Joueur joueurDeleted
) {
}
