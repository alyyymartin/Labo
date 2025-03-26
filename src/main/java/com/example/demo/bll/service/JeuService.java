package com.example.demo.bll.service;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.dal.domain.entity.Jeu;

import java.util.List;

public interface JeuService {
    CreateJeuResponse createJeu(CreateJeuRequest createJeuRequest);

//    List<Jeu> getAllJeux();
}
