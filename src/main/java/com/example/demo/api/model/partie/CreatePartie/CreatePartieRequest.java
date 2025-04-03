package com.example.demo.api.model.partie.CreatePartie;

import com.example.demo.dal.domain.entity.Jeu;

import java.time.LocalDateTime;

public record CreatePartieRequest(
        LocalDateTime date,
        float scoreFinal,
        String commentaire,
        int classement,
        Jeu jeu
) {
}
