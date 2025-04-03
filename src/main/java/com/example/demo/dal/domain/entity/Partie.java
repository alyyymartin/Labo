package com.example.demo.dal.domain.entity;

import com.example.demo.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "parties")
public class Partie extends BaseEntity<Long> {

    @Getter
    @Setter
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Getter
    @Setter
    @Column(name = "score_final", nullable = false)
    private float scoreFinal;

    @Getter
    @Setter
    @Column(name = "commentaire", length = 350)
    private String commentaire;

    @Getter
    @Setter
    @Column(name = "classement", nullable = false)
    private int classement;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn (name = "jeu")
    private Jeu jeu;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn (name = "joueur")
    private Joueur joueur;

}
