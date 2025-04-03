package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.domain.entity.Partie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Long> {

}
