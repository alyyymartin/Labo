package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.repository.JeuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //    @Override
//    public List<GetAllJeuxResponse> getAllJeux() {
//        return List.of();
//    }
}
