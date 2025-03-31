package com.example.demo.api.model.type.FindByType;

import com.example.demo.dal.domain.entity.Type;

public record FindTypeByTypeResponse(
       String message,
       Type type
) {
}
