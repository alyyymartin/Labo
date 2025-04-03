package com.example.demo.api.model.partie.GetAllPartiesByJeuByJoueur;

import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.domain.entity.Joueur;

public record GetAllPartiesByJeuByJoueurRequest(
        Joueur joueur
) {
}
