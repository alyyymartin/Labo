package com.example.demo.bll.serviceImpl;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.Create.CreateTypeResponse;
import com.example.demo.api.model.type.FindByType.FindTypeByTypeResponse;
import com.example.demo.api.model.type.GetAll.GetAllTypesResponse;
import com.example.demo.bll.exception.alreadyExists.AlreadyExistsException;
import com.example.demo.bll.exception.ressourceNotFound.RessourceNotFoundException;
import com.example.demo.bll.service.TypeService;
import com.example.demo.dal.domain.entity.Type;
import com.example.demo.dal.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public CreateTypeResponse createType(CreateTypeRequest createTypeRequest) {
        if (typeRepository.findTypeByType(createTypeRequest.type()) != null) {
            throw new AlreadyExistsException("Un type identique existe déjà.");
        }
        Type typeToCreate = new Type ();
        typeToCreate.setType(createTypeRequest.type());
        typeToCreate.setDescription(createTypeRequest.description());
        typeRepository.save(typeToCreate);
        return new CreateTypeResponse("Le type suivant a bien été créé : ", typeToCreate);
    }

    @Override
    public FindTypeByTypeResponse findTypeByType(String type) {
        Type typeToFind = typeRepository.findTypeByType(type).orElseThrow(() -> new RessourceNotFoundException("Type non existant"));
        return new FindTypeByTypeResponse("Le type recherché est le suivant : ", typeToFind);
    }

    @Override
    public Set<Type> getAllTypes() {
        Set <Type> setAllTypes = new HashSet<>();
        setAllTypes.addAll(typeRepository.findAll());
        return setAllTypes;
    }
}
