package com.example.demo.api.model.jeu.Create;

import com.example.demo.dal.domain.entity.Jeu;
import lombok.Data;

public record CreateJeuResponse (
         String message,
         Jeu jeuToCreate
){
}
