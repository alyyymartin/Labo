package com.example.demo.api.model.jeu.Create;

import com.example.demo.dal.domain.entity.Type;

import java.util.Set;

public record CreateJeuRequest(
        String jeu,
        Integer nbreMinJoueurs,
        Integer nbreMaxJoueurs,
        String description,
        Set<Type> types
) {
}
