package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.partie.CreatePartie.CreatePartieRequest;
import com.example.demo.bll.service.PartieService;
import com.example.demo.dal.domain.entity.Partie;
import com.example.demo.dal.repository.PartieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartieServiceImpl implements PartieService {

    private final PartieRepository partieRepository;

    @Override
    public Partie createPartie(CreatePartieRequest createPartieRequest) {
        Partie partieToCreate = new Partie();
        partieToCreate.setDate(createPartieRequest.date());
        partieToCreate.setJeu(createPartieRequest.jeu());
        partieToCreate.setScoreFinal(createPartieRequest.scoreFinal());
        partieToCreate.setClassement(createPartieRequest.classement());
        partieToCreate.setCommentaire(createPartieRequest.commentaire());
        partieRepository.save(partieToCreate);
        return partieToCreate;
    }
}
