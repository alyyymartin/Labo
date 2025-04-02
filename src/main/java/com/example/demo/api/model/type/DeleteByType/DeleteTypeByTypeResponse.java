package com.example.demo.api.model.type.DeleteByType;

import com.example.demo.dal.domain.entity.Type;

public record DeleteTypeByTypeResponse(

        String message,
        Type deletedType
) {
}
