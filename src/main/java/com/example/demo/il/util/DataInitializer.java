package com.example.demo.il.util;

import com.example.demo.bll.service.JoueurService;
import com.example.demo.dal.domain.entity.Jeu;
import com.example.demo.dal.domain.entity.Joueur;
import com.example.demo.dal.domain.entity.Type;
import com.example.demo.dal.repository.JeuRepository;
import com.example.demo.dal.repository.JoueurRepository;
import com.example.demo.dal.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner {

    private final JeuRepository jeuRepository;
    private final JoueurRepository joueurRepository;
    private final TypeRepository typeRepository;


    @Override
    public void run(String... args) throws Exception {
        if(typeRepository.count() == 0){
            Type typeInitial1 = new Type();
            typeInitial1.setType("Stop and Go");
            typeInitial1.setDescription("Test de description");
            typeRepository.save(typeInitial1);

            Type typeInitial2 = new Type();
            typeInitial2.setType("Deux");
            typeInitial2.setDescription("Test");
            typeRepository.save(typeInitial2);

            Set<Type> types = new HashSet<Type>();
            types.add(typeInitial1);
            types.add(typeInitial2);

            Jeu jeuInitial = new Jeu();
            jeuInitial.setJeu("Catane");
            jeuInitial.setNbreMaxJoueurs(4);
            jeuInitial.setNbreMinJoueurs(1);
            jeuInitial.setDescription("test de description");
            jeuInitial.setTypes(types);
            jeuRepository.save(jeuInitial);

            Joueur joueurInitial = new Joueur();
            joueurInitial.setNom("Martin");
            joueurInitial.setPrenom("Alison");
            joueurInitial.setUsername("Kalio");
            joueurInitial.setPassword("Kalio");
            joueurInitial.setPresentation("Test de présentation");
            joueurRepository.save(joueurInitial);

        }
    }
}
