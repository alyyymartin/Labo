package com.example.demo.bll.service;

import com.example.demo.api.model.type.Create.CreateTypeRequest;
import com.example.demo.api.model.type.UpdateTypeByType.UpdateTypeByTypeRequest;
import com.example.demo.dal.domain.entity.Type;

import java.util.List;

public interface TypeService {

    Type createType (CreateTypeRequest createTypeRequest);
    Type findTypeByType (String type);
    List<Type> getAllTypes();
    Type deleteTypeByType(String type);
    Type updateTypeByType (UpdateTypeByTypeRequest updateTypeByTypeRequest);
}
