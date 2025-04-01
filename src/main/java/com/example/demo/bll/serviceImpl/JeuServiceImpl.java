package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.DeleteJeuByJeu.DeleteJeuByJeuResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.repository.JeuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;

    @Override
    public CreateJeuResponse createJeu(CreateJeuRequest createJeuRequest) {
        Optional<Jeu> jeuToFind = jeuRepository.getJeuByJeu(createJeuRequest.jeu());
        if (jeuToFind.isPresent()) {
            throw new AlreadyExistsException("Un jeu existe déjà avec ce nom.");
        } else {
            Jeu jeuToCreate = new Jeu ();
            jeuToCreate.setJeu(createJeuRequest.jeu());
            jeuToCreate.setNbreMaxJoueurs(createJeuRequest.nbreMaxJoueurs());
            jeuToCreate.setNbreMinJoueurs(createJeuRequest.nbreMinJoueurs());
            jeuToCreate.setDescription(createJeuRequest.description());
            jeuRepository.save(jeuToCreate);
            return new CreateJeuResponse("Le jeu suivant a bien été créé :", jeuToCreate);
        }
    }

    @Override
    public Set<Jeu> getAllJeux() {
        Set <Jeu> setAllJeux = new HashSet<>();
        setAllJeux.addAll(jeuRepository.findAll());
        return setAllJeux;
    }

    @Override
    public GetJeuByJeuResponse getJeuByJeu(String jeu) {
        Jeu jeuToFind = jeuRepository.getJeuByJeu(jeu)
                .orElseThrow(() -> new RessourceNotFoundException("Jeu introuvable"));
        return new GetJeuByJeuResponse(jeuToFind);
    }

    @Override
    public DeleteJeuByJeuResponse deleteJeuByJeu(String jeu) {
        Jeu jeuToDelete = jeuRepository.getJeuByJeu(jeu)
                .orElseThrow(() -> new RessourceNotFoundException("Jeu inexistant"));
        jeuRepository.delete(jeuToDelete);
        return new DeleteJeuByJeuResponse("Le jeu suivant a bien été supprimé : ", jeuToDelete);
    }
}