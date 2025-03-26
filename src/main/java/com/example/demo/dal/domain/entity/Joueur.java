package com.example.demo.dal.domain.entity;

import com.example.demo.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "joueurs")
public class Joueur extends BaseEntity<Long>  {

    @Getter
    @Setter
    @Column(name = "Username",unique = true, nullable = false, length = 50)
    private String username;

    @Getter @Setter
    @Column(name = "Mot_de_passe", nullable = false)
    private String password;

    @Getter @Setter
    @Column(name = "Nom", nullable = false)
    private String nom;

    @Getter @Setter
    @Column(name = "Prénom", nullable = false)
    private String prenom;

    @Getter @Setter
    @Column(name = "Présentation")
    private String presentation;

    public Joueur(Optional<Joueur> byUsername) {
    }
}
