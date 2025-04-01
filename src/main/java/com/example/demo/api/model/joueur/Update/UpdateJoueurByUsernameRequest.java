package com.example.demo.api.model.joueur.Update;

public record UpdateJoueurByUsernameRequest(
        String Nom,
        String Prenom,
        String Presentation,
        String Password
) {
}
