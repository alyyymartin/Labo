package com.example.demo.api.model.jeu.DeleteJeuById;

import com.example.demo.dal.domain.entity.Jeu;

public record DeleteJeuByIdResponse(
        String message,
        Jeu jeuDeleted
) {
}
