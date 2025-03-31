package com.example.demo.bll.service;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.Create.CreateTypeResponse;
import com.example.demo.api.model.type.FindByType.FindTypeByTypeResponse;
import com.example.demo.api.model.type.GetAll.GetAllTypesResponse;
import com.example.demo.dal.domain.entity.Type;

import java.util.HashSet;
import java.util.Set;

public interface TypeService {

    CreateTypeResponse createType (CreateTypeRequest createTypeRequest);
    FindTypeByTypeResponse findTypeByType (String type);
    Set<Type> getAllTypes();
}
