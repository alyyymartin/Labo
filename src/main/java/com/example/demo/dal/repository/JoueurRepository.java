package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {

    @Query( "Select j " +
            "from Joueur j " +
            "where j.username ilike :username")
    Optional<Joueur> findByUsername(String username);

}
