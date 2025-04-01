package com.example.demo.api.model.joueur.GetAll;

import com.example.demo.dal.domain.entity.Joueur;

import java.util.Set;

public record GetAllJoueursResponse(
       Set<Joueur> setGetAllJoueursResponse
) {
}
