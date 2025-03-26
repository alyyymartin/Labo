package com.example.demo.api.model.jeu.Create;

public record CreateJeuRequest(
        String jeu,
        Integer nbreMinJoueurs,
        Integer nbreMaxJoueurs,
        String description
) {
}
