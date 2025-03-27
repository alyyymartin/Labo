package com.example.demo.bll.service;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.dal.domain.entity.Jeu;

import java.util.Set;

public interface JeuService {

    CreateJeuResponse createJeu(CreateJeuRequest createJeuRequest);

    Set<Jeu> getAllJeux();

    GetJeuByJeuResponse getJeuByJeu(String jeu);
}

