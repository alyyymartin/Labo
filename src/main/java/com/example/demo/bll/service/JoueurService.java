package com.example.demo.bll.service;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.api.model.joueur.GetByUsername.GetByUsernameResponse;
import com.example.demo.dal.domain.entity.Joueur;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;

public interface JoueurService {

    CreateJoueurResponse createJoueur (CreateJoueurRequest createJoueurRequest);
    Joueur findJoueurByUsername(String usernameJoueurToCreate);
}

