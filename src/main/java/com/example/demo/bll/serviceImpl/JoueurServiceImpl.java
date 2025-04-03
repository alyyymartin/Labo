package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameRequest;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.JoueurService;
import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.repository.JoueurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;

    @Override
    public Joueur findJoueurByUsername(String username) {
        Joueur joueurtoFind = joueurRepository.findByUsername(username)
                .orElseThrow(() -> new RessourceNotFoundException("Joueur introuvable"));
        return joueurtoFind;
    }

    @Override
    public Joueur createJoueur(CreateJoueurRequest createJoueurRequest) {
        Optional <Joueur> joueurtoFind = joueurRepository.findByUsername(createJoueurRequest.username());
        if (joueurtoFind.isPresent()) {
            throw new AlreadyExistsException("Un joueur existe déjà avec ce nom d'utilisateur.");
        } else {
        Joueur joueurToCreate = new Joueur();
        joueurToCreate.setUsername(createJoueurRequest.username());
        joueurToCreate.setNom(createJoueurRequest.nom());
        joueurToCreate.setPrenom(createJoueurRequest.prenom());
        joueurToCreate.setPassword(createJoueurRequest.password());
        joueurToCreate.setPresentation(createJoueurRequest.presentation());
        joueurRepository.save(joueurToCreate);
        return joueurToCreate;
        }
    }

    @Override
    public Set<Joueur> getAllJoueurs() {
        Set<Joueur> setAllJoueurs = new HashSet<>();
        setAllJoueurs.addAll(joueurRepository.findAll());
        return setAllJoueurs;
    }

    @Override
    public Joueur deleteJoueurByUsername(String username) {
        Joueur joueurToDelete = joueurRepository.findByUsername(username)
                .orElseThrow(() -> new RessourceNotFoundException("Joueur inexistant"));
        joueurRepository.delete(joueurToDelete);
        return joueurToDelete;
    }

    @Override
    public Joueur updateJoueurByUsername(String username, UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest) {
        Joueur joueurUpDated = joueurRepository.findByUsername(username)
                .orElseThrow(() -> new RessourceNotFoundException("Joueur introuvable"));

        joueurUpDated.setPassword(updateJoueurByUsernameRequest.password());
        joueurUpDated.setNom(updateJoueurByUsernameRequest.nom());
        joueurUpDated.setPrenom(updateJoueurByUsernameRequest.prenom());
        joueurUpDated.setPresentation(updateJoueurByUsernameRequest.presentation());
        joueurRepository.save(joueurUpDated);

        return joueurUpDated;
    }
}
