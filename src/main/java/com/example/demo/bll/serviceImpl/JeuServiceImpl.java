package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.repository.JeuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;

    @Override
    public CreateJeuResponse createJeu(CreateJeuRequest createJeuRequest) {
        Jeu jeuToCreate = new Jeu ();
        jeuToCreate.setJeu(createJeuRequest.jeu());
        jeuToCreate.setNbreMaxJoueurs(createJeuRequest.nbreMaxJoueurs());
        jeuToCreate.setNbreMinJoueurs(createJeuRequest.nbreMinJoueurs());
        jeuToCreate.setDescription(createJeuRequest.description());
        jeuRepository.save(jeuToCreate);
        return new CreateJeuResponse("Le jeu suivant a bien été créé :", jeuToCreate);
    }

    @Override
    public Set<Jeu> getAllJeux() {
        Set <Jeu> setAllJeux = new HashSet<>();
        setAllJeux.addAll(jeuRepository.findAll());
        return setAllJeux;
    }

    @Override
    public GetJeuByJeuResponse getJeuByJeu(String jeu) {
        Jeu jeuToFind = new Jeu();
        jeuToFind = jeuRepository.getJeuByJeu(jeu);
        return new GetJeuByJeuResponse(jeuToFind);
    }
}

