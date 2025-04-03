package com.example.demo.api.model.joueur.Update;

import com.example.demo.dal.domain.entity.Joueur;

public record UpdateJoueurByUsernameResponse(

        String messageAncien,
        Joueur joueurToUpdate,

        String messageNouveau,
        Joueur joueurUpdated
) {
}
