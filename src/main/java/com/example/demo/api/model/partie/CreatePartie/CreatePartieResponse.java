package com.example.demo.api.model.partie.CreatePartie;

import com.example.demo.dal.domain.entity.Partie;

public record CreatePartieResponse(
        String message,
        Partie partie
) {
}
