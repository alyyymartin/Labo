package com.example.demo.bll.service;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.Create.CreateTypeResponse;
import com.example.demo.api.model.type.FindByType.FindTypeByTypeResponse;
import com.example.demo.dal.domain.entity.Type;

import java.util.List;

public interface TypeService {

    CreateTypeResponse createType (CreateTypeRequest createTypeRequest);
    FindTypeByTypeResponse findTypeByType (String type);
    List<Type> getAllTypes();
}
