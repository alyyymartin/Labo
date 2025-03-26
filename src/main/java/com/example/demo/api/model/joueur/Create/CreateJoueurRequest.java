package com.example.demo.api.model.joueur.Create;

public record CreateJoueurRequest(
        String username,
        String password,
        String nom,
        String prenom,
        String presentation
) {
}
