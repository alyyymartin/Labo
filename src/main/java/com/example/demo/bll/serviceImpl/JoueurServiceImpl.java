package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.api.model.joueur.DeleteByUsername.DeleteJoueurByUsernameResponse;
import com.example.demo.api.model.joueur.GetAll.GetAllJoueursResponse;
import com.example.demo.api.model.joueur.GetByUsername.GetByUsernameResponse;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameRequest;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameResponse;
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
    public GetByUsernameResponse findJoueurByUsername(String username) {
        Joueur joueurtoFind = joueurRepository.findByUsername(username)
                .orElseThrow(() -> new RessourceNotFoundException("Joueur introuvable"));
        GetByUsernameResponse getByUsernameResponse = new GetByUsernameResponse("Voici les infos du joueur recherché : ", joueurRepository.findByUsername(username));
        return getByUsernameResponse;
    }

    @Override
    public CreateJoueurResponse createJoueur(CreateJoueurRequest createJoueurRequest) {
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
        return new CreateJoueurResponse("Le joueur suivant a bien été créé : ", joueurToCreate);
        }
    }

    @Override
    public GetAllJoueursResponse getAllJoueurs() {
        Set<Joueur> setAllJoueurs = new HashSet<>();
        setAllJoueurs.addAll(joueurRepository.findAll());
        return new GetAllJoueursResponse(setAllJoueurs);
    }

    @Override
    public DeleteJoueurByUsernameResponse deleteJoueurByUsername(String username) {
        Joueur joueurToDelete = joueurRepository.findByUsername(username)
                .orElseThrow(() -> new RessourceNotFoundException("Joueur inexistant"));
        joueurRepository.delete(joueurToDelete);
        return new DeleteJoueurByUsernameResponse("Le joueur suivant a bien été supprimé : ", joueurToDelete);
    }



//    @Override
//    public UpdateJoueurByUsernameResponse updateJoueurByUsername(String username, UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest) {
//
//        Joueur joueurToUpdate = joueurRepository.findByUsername(username)
//                .orElseThrow(() -> new RessourceNotFoundException("Joueur introuvable"));
//
//        String ancienNom = joueurToUpdate.getNom();
//        String ancienPrenom = joueurToUpdate.getPrenom();
//        String anciennePresentation = joueurToUpdate.getPresentation();
//        String ancienPassword = joueurToUpdate.getPassword();
//
//        joueurToUpdate.setUsername(username);
//        joueurToUpdate.setPassword(updateJoueurByUsernameRequest.Password());
//        joueurToUpdate.setNom(updateJoueurByUsernameRequest.Nom());
//        joueurToUpdate.setPrenom(updateJoueurByUsernameRequest.Prenom());
//        joueurToUpdate.setPresentation(updateJoueurByUsernameRequest.Presentation());
//
//
//        joueurRepository.save(joueurToUpdate);
////
//        return new UpdateJoueurByUsernameResponse("Mise à jour effectuée avec succès !");
//    }
//
////    return new UpdateJoueurByUsernameResponse(
////            "Anciennes données du joueur ", username, ancienNom, ancienPrenom, anciennePresentation, ancienPassword,
////            "Nouvelles données : ",
////            joueurToUpdate.getNom(),
////            joueurToUpdate.getPrenom(),
////            joueurToUpdate.getPassword(),
////            joueurToUpdate.getPresentation()
////    );}
}
