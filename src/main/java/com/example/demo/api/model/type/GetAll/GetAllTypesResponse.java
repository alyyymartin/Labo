package com.example.demo.api.model.type.GetAll;

import com.example.demo.dal.domain.entity.Type;

import java.util.List;

public record GetAllTypesResponse(
        List<Type> type
) {
}
