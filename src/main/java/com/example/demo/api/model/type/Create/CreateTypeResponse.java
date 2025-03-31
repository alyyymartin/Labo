package com.example.demo.api.model.type.Create;

import com.example.demo.dal.domain.entity.Type;
import lombok.*;

@Data
public class CreateTypeResponse{

    private String message;
    private Type type;

    public CreateTypeResponse (String message, Type type){
        this.message = message;
        this.type = type;
    }

    public CreateTypeResponse (String message){
        this.message = message;
    }

}
