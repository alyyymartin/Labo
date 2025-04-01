package com.example.demo.api.model.joueur.Create;

import com.example.demo.dal.domain.entity.Joueur;

public record CreateJoueurResponse(
    String message,
    Joueur joueur
){

}
