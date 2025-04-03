package com.example.demo.bll.service;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameRequest;
import com.example.demo.dal.domain.entity.Joueur;


import java.util.Set;

public interface JoueurService {

    Joueur createJoueur (CreateJoueurRequest createJoueurRequest);

    Joueur findJoueurByUsername(String username);

    Set<Joueur> getAllJoueurs();

    Joueur deleteJoueurByUsername (String username);

    Joueur updateJoueurByUsername(String username, UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest);
}
