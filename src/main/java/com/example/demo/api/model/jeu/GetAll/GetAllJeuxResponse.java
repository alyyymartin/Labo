package com.example.demo.api.model.jeu.GetAll;

import com.example.demo.dal.domain.entity.Jeu;

import java.util.Set;

public record GetAllJeuxResponse(
        Set<Jeu> jeu
) {
}
