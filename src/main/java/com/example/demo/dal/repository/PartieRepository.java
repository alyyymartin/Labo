package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {

    //Récupérer toutes les parties d'un joueur à un jeu donné. Merci ChatGPT!
    @Query("SELECT p FROM Partie p " +
            "JOIN p.joueur j " +
            "JOIN p.jeu jeu " +
            "WHERE j.username = :username " +
            "AND jeu.jeu = :jeu")
    List<Partie> getAllPartiesByJeuByJoueur(String jeu, String username);
}
