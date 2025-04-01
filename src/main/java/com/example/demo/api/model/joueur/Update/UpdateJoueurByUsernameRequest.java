package com.example.demo.api.model.joueur.Update;

public record UpdateJoueurByUsernameRequest(
        String nom,
        String prenom,
        String presentation,
        String password
) {
}
