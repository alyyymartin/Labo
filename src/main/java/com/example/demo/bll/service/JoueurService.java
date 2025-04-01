package com.example.demo.bll.service;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.api.model.joueur.DeleteByUsername.DeleteJoueurByUsernameResponse;
import com.example.demo.api.model.joueur.GetAll.GetAllJoueursResponse;
import com.example.demo.api.model.joueur.GetByUsername.GetByUsernameResponse;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameRequest;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameResponse;
import com.example.demo.dal.domain.entity.Joueur;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Set;

public interface JoueurService {

    CreateJoueurResponse createJoueur (CreateJoueurRequest createJoueurRequest);

    GetByUsernameResponse findJoueurByUsername(String username);

    GetAllJoueursResponse getAllJoueurs();

    DeleteJoueurByUsernameResponse deleteJoueurByUsername (String username);

    UpdateJoueurByUsernameResponse updateJoueurByUsername(String username, UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest);
}
