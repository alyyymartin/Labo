package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.domain.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TypeRepository extends JpaRepository <Type, Long> {

    @Query("Select t " +
            "from Type t  " +
            "where t.id IN :typeId")
    Set<Type> getAllJeuxByTypeId(Set<Long> typeId);

    @Query("Select t " +
            "from Type t  " +
            "where t.type ilike :newType")
    Optional<Type> findTypeByType(String newType);

}