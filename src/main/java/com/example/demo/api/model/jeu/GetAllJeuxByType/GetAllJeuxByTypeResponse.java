package com.example.demo.api.model.jeu.GetAllJeuxByType;

import com.example.demo.dal.domain.entity.Jeu;

import java.util.List;

public record GetAllJeuxByTypeResponse(

        List<Jeu> listAllJeuxByType

) {
}
