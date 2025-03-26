package com.example.demo.api.model.jeu.GetAll;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

public record GetAllJeuxResponse(
        String jeu,
        Integer nbreMinJoueurs,
        Integer nbreMaxJoueurs,
        String description
) {
}
