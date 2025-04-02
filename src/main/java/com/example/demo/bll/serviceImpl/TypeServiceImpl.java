package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.TypeService;
import com.example.demo.dal.domain.entity.Type;
import com.example.demo.dal.repository.JeuRepository;
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
        Optional <Type> typeToFind = typeRepository.findTypeByType(createTypeRequest.type());
        if (typeToFind != null) {
            throw new AlreadyExistsException("Un type identique existe déjà.");
        } else {
            Type typeToCreate = new Type();
            typeToCreate.setType(createTypeRequest.type());
            typeToCreate.setDescription(createTypeRequest.description());
            typeRepository.save(typeToCreate);
            return typeToCreate;
        }
    }

    @Override
    public Type findTypeByType(String type) {
        Type typeToFind = typeRepository.findTypeByType(type).orElseThrow(() -> new RessourceNotFoundException("Type non existant"));
        return typeToFind;
    }

    @Override
    public List<Type> getAllTypes() {
        List <Type> setAllTypes = new ArrayList<>();
        setAllTypes.addAll(typeRepository.findAll());
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

}
