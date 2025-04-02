package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.DeleteJeuByJeu.DeleteJeuByJeuResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.domain.entity.Type;
import com.example.demo.dal.repository.JeuRepository;
import com.example.demo.dal.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;
    private final TypeRepository typeRepository;

    @Override
    public Jeu createJeu(CreateJeuRequest createJeuRequest) {

        Optional<Jeu> jeuToFind = jeuRepository.getJeuByJeu(createJeuRequest.jeu());
        if (jeuToFind.isPresent()) {
            throw new AlreadyExistsException("Un jeu existe déjà avec ce nom.");
        }

        Set<Type> types = createJeuRequest.types();
        Set<Type> checkedTypes = new HashSet<>();

        for (Type type : types) {
            Optional<Type> typeToFind = typeRepository.findTypeByType(type.getType());

            if (!typeToFind.isPresent()) {
                throw new RessourceNotFoundException("Le type souhaité n'existe pas");
            }

            checkedTypes.add(typeToFind.get());
        }

        Jeu jeuToCreate = new Jeu();
        jeuToCreate.setJeu(createJeuRequest.jeu());
        jeuToCreate.setNbreMaxJoueurs(createJeuRequest.nbreMaxJoueurs());
        jeuToCreate.setNbreMinJoueurs(createJeuRequest.nbreMinJoueurs());
        jeuToCreate.setDescription(createJeuRequest.description());
        jeuToCreate.setTypes(checkedTypes);
        jeuRepository.save(jeuToCreate);
        return jeuToCreate;
    }

    @Override
    public List<Jeu> getAllJeux() {
        List <Jeu> listAllJeux = new ArrayList<>();
        listAllJeux.addAll(jeuRepository.findAll());
        return listAllJeux;
    }

    @Override
    public GetJeuByJeuResponse getJeuByJeu(String jeu) {
        Jeu jeuToFind = jeuRepository.getJeuByJeu(jeu)
                .orElseThrow(() -> new RessourceNotFoundException("Jeu introuvable"));
        return new GetJeuByJeuResponse(jeuToFind);
    }

    @Override
    public List<Jeu> getJeuxByType(String type) {
        Type referenceType = typeRepository.findTypeByType(type)
                .orElseThrow(() -> new RessourceNotFoundException("Type introuvable"));
        return jeuRepository.findAllJeuxByType(type);
    }

    @Override
    public DeleteJeuByJeuResponse deleteJeuByJeu(String jeu) {
        Jeu jeuToDelete = jeuRepository.getJeuByJeu(jeu)
                .orElseThrow(() -> new RessourceNotFoundException("Jeu inexistant"));
        jeuRepository.delete(jeuToDelete);
        return new DeleteJeuByJeuResponse("Le jeu suivant a bien été supprimé : ", jeuToDelete);
    }
}