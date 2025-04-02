package com.example.demo.dal.repository;

import com.example.demo.dal.domain.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository <Type, Long> {

//    Query si je veux seulement afficher un type lorsqu'il est actif :
//    @Query("Select t " +
//            "from Type t  " +
//            "where t.type ilike :newType and active = true")
//    Optional<Type> findTypeByType(String newType);

    @Query("Select t " +
            "from Type t  " +
            "where t.type ilike :newType")
    Optional<Type> findTypeByType(String newType);
}