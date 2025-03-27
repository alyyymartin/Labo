package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.domain.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface JeuRepository extends JpaRepository<Jeu, Long> {

    @Query ("Select j " +
            "from Jeu j " +
            "where j.jeu ilike :jeu")
    Jeu getJeuByJeu(@Param("jeu") String jeu);
}
