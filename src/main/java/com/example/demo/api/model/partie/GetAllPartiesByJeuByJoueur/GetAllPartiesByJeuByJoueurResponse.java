package com.example.demo.api.model.partie.GetAllPartiesByJeuByJoueur;

import com.example.demo.dal.domain.entity.Partie;

import java.util.List;

public record GetAllPartiesByJeuByJoueurResponse(
        List<Partie> getAllPartiesByJeuByJoueurResponse
) {
}
