package com.example.demo.api.model.joueur.Update;

public record UpdateJoueurByUsernameResponse(

        String messageAncien,
        String username,
        String ancienPassword,
        String ancienNom,
        String ancienPrenom,
        String anciennePresentation,

        String messageNouveau,
        String nouveauPassword,
        String nouveauNom,
        String nouveauPrenom,
        String nouvelleresentation
) {
}
