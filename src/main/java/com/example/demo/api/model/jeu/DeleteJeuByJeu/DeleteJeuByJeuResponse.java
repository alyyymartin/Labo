package com.example.demo.api.model.jeu.DeleteJeuByJeu;

import com.example.demo.dal.domain.entity.Jeu;

public record DeleteJeuByJeuResponse(
        String message,
        Jeu jeuDeleted
) {
}
