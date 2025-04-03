package com.example.demo.bll.service;

import com.example.demo.api.model.partie.CreatePartie.CreatePartieRequest;
import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.domain.entity.Partie;

import java.util.List;

public interface PartieService {

    Partie createPartie(CreatePartieRequest createPartieRequest);

    List<Partie> getAllPartiesByJeuByJoueur(String jeu, Joueur joueur);
}
