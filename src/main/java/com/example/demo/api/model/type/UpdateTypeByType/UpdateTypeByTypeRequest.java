package com.example.demo.api.model.type.UpdateTypeByType;

public record UpdateTypeByTypeRequest(
        String type,
        String description,
        Boolean active
) {
}
