package com.example.demo.dal.domain.entity;

import com.example.demo.dal.domain.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "jeux")
public class Jeu extends BaseEntity<Long> {

    @Getter
    @Setter
    @Column(name = "Jeu",unique = true, nullable = false, length = 50)
    private String jeu;

    @Getter
    @Setter
    @Column(name = "Nbre_min_joueurs", nullable = false)
    private Integer nbreMinJoueurs;

    @Getter
    @Setter
    @Column(name = "Nbre_max_joueurs", nullable = false)
    private Integer nbreMaxJoueurs;

    @Getter
    @Setter
    @Column(name = "Description")
    private String description;

    @Getter
    @Setter
    @ManyToMany (fetch = FetchType.EAGER)
//    , cascade = CascadeType.ALL
    @JoinTable (
            name = "jeu_type",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    private Set<Type> types;
}
