package com.example.demo.api.model.joueur.GetByUsername;

import com.example.demo.dal.domain.entity.Joueur;

public record GetByUsernameResponse(
        String message,
        java.util.Optional<Joueur> joueurToFind
) {
}
