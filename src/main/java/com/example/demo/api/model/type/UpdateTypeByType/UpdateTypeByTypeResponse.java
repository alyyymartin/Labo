package com.example.demo.api.model.type.UpdateTypeByType;

import com.example.demo.dal.domain.entity.Type;

public record UpdateTypeByTypeResponse(
        String messageNouveau,
        Type nouveauType
) {
}
