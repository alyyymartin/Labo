package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.UpdateTypeByType.UpdateTypeByTypeRequest;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.TypeService;
import com.example.demo.dal.domain.entity.Type;
import com.example.demo.dal.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public Type createType(CreateTypeRequest createTypeRequest) {

        //Création d'un objet Type qui reprend les infos de la createTypeRequest:
        Type typeToCreate = new Type();
        typeToCreate.setType(createTypeRequest.type());
        typeToCreate.setDescription(createTypeRequest.description());

        //Création d'un objet Type qui sera retourné en fin de méthode et qui contiendra soit l'objet que ma méthode findTypeByType retourne s'il n'est pas null (car retourne un optional), soit l'objet créé à partir de ma request :
        var opt = this.typeRepository.findTypeByType(createTypeRequest.type());
        Type toReturn = opt.orElse(typeToCreate);

        //Vérifie si findTypeByType a retourné un objet ET s'il est inactif -> le passe en actif
        if (opt.isPresent() && !toReturn.isActive()) {
            toReturn.setActive(true);
            typeRepository.save(toReturn);
        }

        //Vérifie si findTypeByType a retourné un objet ET s'il est actif -> informe qu'il existe déjà
        else if (opt.isPresent() && toReturn.isActive()){
            throw new AlreadyExistsException("Un type identique existe déjà.");
        }

        //Vérifie si findTypeByType n'a pas retourné d'objet -> crée l'objet
        else if (opt.isEmpty())  {
            typeRepository.save(toReturn);
        }

        return toReturn;
    }

    @Override
    public Type findTypeByType(String type) {
        Type typeToFind = typeRepository.findTypeByType(type)
                .orElseThrow(() -> new RessourceNotFoundException("Type non existant"));
        return typeToFind;
    }

    @Override
    public List<Type> getAllTypes() {
        List <Type> setAllTypes = new ArrayList<>(typeRepository.findAll());
        return setAllTypes;
    }

    @Override
    public Type deleteTypeByType(String type) {
        //Vérifie si le type que l'on souhaite supprimer existe bien en DB.
        Type typeToDelete = typeRepository.findTypeByType(type)
                .orElseThrow(() -> new RessourceNotFoundException("Type non existant"));
        //Le type n'est pas réellement supprimé, il est juste désactivé et ne peut plus être utilisé, mais sa "suppression" n'a aucun impact sur les jeux qui l'utilisent.
        typeToDelete.setActive(false);
        typeRepository.save(typeToDelete);
        return typeToDelete;
    }

    @Override
    public Type updateTypeByType(UpdateTypeByTypeRequest updateTypeByTypeRequest) {

        Type nouveauType = typeRepository.findTypeByType(updateTypeByTypeRequest.type())
                .orElseThrow(()-> new RessourceNotFoundException("Type inexistant"));
        nouveauType.setType(updateTypeByTypeRequest.type());
        nouveauType.setDescription(updateTypeByTypeRequest.description());
        nouveauType.setActive(updateTypeByTypeRequest.active());
        typeRepository.save(nouveauType);

        return nouveauType;
    }
}
// public UpdateJoueurByUsernameResponse updateJoueurByUsername(String username, UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest) {
//        Joueur joueurToUpdate = joueurRepository.findByUsername(username)
//                .orElseThrow(() -> new RessourceNotFoundException("Joueur introuvable"));
//
//        Joueur ancienJoueur = new Joueur
//        String ancienPrenom = joueurToUpdate.getPrenom();
//        String anciennePresentation = joueurToUpdate.getPresentation();
//        String ancienPassword = joueurToUpdate.getPassword();
//
//        joueurToUpdate.setUsername(username);
//        joueurToUpdate.setPassword(updateJoueurByUsernameRequest.password());
//        joueurToUpdate.setNom(updateJoueurByUsernameRequest.nom());
//        joueurToUpdate.setPrenom(updateJoueurByUsernameRequest.prenom());
//        joueurToUpdate.setPresentation(updateJoueurByUsernameRequest.presentation());
//
//        joueurRepository.save(joueurToUpdate);
//
//        return new UpdateJoueurByUsernameResponse(
//                "Anciennes données du joueur ", username, ancienPassword, ancienNom, ancienPrenom, anciennePresentation,
//                "Nouvelles données : ",
//                joueurToUpdate.getPassword(),
//                joueurToUpdate.getNom(),
//                joueurToUpdate.getPrenom(),
//                joueurToUpdate.getPresentation()
//        );