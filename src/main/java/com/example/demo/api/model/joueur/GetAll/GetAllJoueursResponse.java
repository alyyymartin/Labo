package com.example.demo.api.model.joueur.GetAll;

import com.example.demo.dal.domain.entity.Joueur;

import java.util.Optional;

public record GetAllJoueursResponse(
        Optional<Joueur> joueur
) {
}
