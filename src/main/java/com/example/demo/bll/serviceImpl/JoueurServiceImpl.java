package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.api.model.joueur.GetByUsername.GetByUsernameResponse;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.JoueurService;
import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.repository.JoueurRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoueurServiceImpl implements JoueurService {

    private final JoueurRepository joueurRepository;

    @Override
    public Joueur findJoueurByUsername(String username) {
        Optional <Joueur> joueurtoFind = joueurRepository.findByUsername(username);
        return joueurtoFind .orElseThrow();
    }

    @Override
    public CreateJoueurResponse createJoueur(CreateJoueurRequest createJoueurRequest) {

        String usernameJoueurToCreate = createJoueurRequest.username();
        Joueur joueurToCreate = new Joueur(joueurRepository.findByUsername(usernameJoueurToCreate));

        if (joueurToCreate != null) {
            joueurToCreate.setUsername(createJoueurRequest.username());
            joueurToCreate.setNom(createJoueurRequest.nom());
            joueurToCreate.setPrenom(createJoueurRequest.prenom());
            joueurToCreate.setPassword(createJoueurRequest.password());
            joueurToCreate.setPresentation(createJoueurRequest.presentation());
            joueurRepository.save(joueurToCreate);
            return new CreateJoueurResponse("Le joueur suivant a bien été créé : ", joueurToCreate.toString());
        } else {
            return new CreateJoueurResponse("Impossible de créer le joueur suivant : ", joueurToCreate.toString());
        }
    }
}
