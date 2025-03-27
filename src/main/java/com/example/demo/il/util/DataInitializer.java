package com.example.demo.il.util;


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

            //Création de tous les types initiaux
            Type typeInitial1 = new Type();
            typeInitial1.setType("Pose de tuiles");
            typeInitial1.setDescription("Le plateau de jeu se construit via la pose de tuiles.");
            typeRepository.save(typeInitial1);

            Type typeInitial2 = new Type("Adresse", "Fait intervenir l'habileté des joueurs");
            typeRepository.save(typeInitial2);

            Type typeInitial3 = new Type("Bluff", "Les émotions des joueurs et le comportement agissent sur les actions.");
            typeRepository.save(typeInitial3);

            Type typeInitial4 = new Type("Connaissance", "Cible une ou plusieurs thématiques sur lesquelles sont posées des questions.");
            typeRepository.save(typeInitial4);

            Type typeInitial5 = new Type("Coopératif", "Un jeu coopératif est un jeu dans lequel tous les joueurs gagnent ou perdent ensemble, en cherchant à comprendre, maîtriser et dépasser les règles automatiques du jeu.");
            typeRepository.save(typeInitial5);

            Type typeInitial6 = new Type("Draft", "Les joueurs choisissent un élément avant de faire passer le reste des éléments au joueur à côté de lui, qui répète l'opération jusqu'à épuisement de la ressource.");
            typeRepository.save(typeInitial6);

            Type typeInitial7 = new Type("DeckBuilding", "Les joueurs possèdent un paquet de cartes de départ et le fait évoluer en ajoutant ou supprimant des cartes pour le rendre plus puissant.");
            typeRepository.save(typeInitial7);

            Type typeInitial8 = new Type("Enchères", "Les joueurs devront faire des offres plus importantes que les autres.");
            typeRepository.save(typeInitial8);

            Type typeInitial9 = new Type("Commerce", "Les joueurs échangent entre eux des cartes ou d'autres objets.");
            typeRepository.save(typeInitial9);

            Type typeInitial10 = new Type("Gages", "Les règles imposent des gages à tour de rôle ou au joueur ayant raté une épreuve (action ou vérité ?, jeu à boire…).");
            typeRepository.save(typeInitial10);

            Type typeInitial11 = new Type("Hasard", "Le déroulement du jeu est dépendant du hasard (dés, cartes mélangées, roues, tirage de cubes dans un sac…).");
            typeRepository.save(typeInitial11);

            Type typeInitial12 = new Type("Majorité", "Il faut avoir la majorité de tuiles / cartes / jetons pour effectuer des actions ou pour remporter la partie.");
            typeRepository.save(typeInitial12);

            Type typeInitial13 = new Type("Mémoire", "Nécessite de retenir des informations pour pouvoir avancer dans le jeu.");
            typeRepository.save(typeInitial13);

            Type typeInitial14 = new Type("Observation", "Les joueurs doivent repérer visuellement des éléments.");
            typeRepository.save(typeInitial14);

            Type typeInitial15 = new Type("Parcours", " La progression des joueurs suit une piste et le joueur arrivant le plus loin ou qui atteint l'arrivée est le gagnant.");
            typeRepository.save(typeInitial15);

            Type typeInitial16 = new Type("Réflexe", "Les réflexes des joueurs interviennent.");
            typeRepository.save(typeInitial16);

            Type typeInitial17 = new Type("Rapidité", "La rapidité des joueurs intervient.");
            typeRepository.save(typeInitial17);

            Type typeInitial18 = new Type("Déduction", "Les joueurs doivent utiliser la logique.");
            typeRepository.save(typeInitial18);

            Type typeInitial19 = new Type("Sens", "Une bonne utilisation des sens permettra de gagner (trouver un objet dans un sac, trouver quel plat on goûte…).");
            typeRepository.save(typeInitial19);

            Type typeInitial20 = new Type("Tetris", "Pas de description");
            typeRepository.save(typeInitial20);

            Type typeInitial21 = new Type("Stop and Go", "Il faut décider de continuer l'action ou de l'arrêter avant que quelque chose de négatif ne se produise.");
            typeRepository.save(typeInitial21);

            Type typeInitial22 = new Type("Stratégie", "Les différents coups sont exécutés sur des groupes ou en générant une suite de combinaisons.");
            typeRepository.save(typeInitial22);

            Type typeInitial23 = new Type("Tactique", "Les différents coups sont exécutés avec des combinaisons de mouvements ou d'actions tous identifiés.");
            typeRepository.save(typeInitial23);

            Type typeInitial24 = new Type("Plateau", "Se joue sur un plateau.");
            typeRepository.save(typeInitial24);

            Type typeInitial25 = new Type("Cartes", "Se joue avec des cartes.");
            typeRepository.save(typeInitial25);

            Type typeInitial26 = new Type("Civilisation", "Porte sur le thème de l'évolution d'une civilisation");
            typeRepository.save(typeInitial26);

            Type typeInitial27 = new Type("Placement d'ouvriers", "Repose sur le placement d'ouvriers");
            typeRepository.save(typeInitial27);

            Type typeInitial28 = new Type("Gestion de ressources", "Implique de la gestion de ressources.");
            typeRepository.save(typeInitial28);

            Type typeInitial29 = new Type("Semi-coopératif", "Nécessite de jouer avec les autres joueurs pour réussir, mais il n'y a qu'un seul gagnant.");
            typeRepository.save(typeInitial29);

            //Création jeuInitial 1
            Set<Type> typesJeuInitial1 = new HashSet<>();
            typesJeuInitial1.add(typeInitial28);
            typesJeuInitial1.add(typeInitial11);
            typesJeuInitial1.add(typeInitial22);

            Jeu jeuInitial1 = new Jeu();
            jeuInitial1.setJeu("Catane");
            jeuInitial1.setNbreMaxJoueurs(4);
            jeuInitial1.setNbreMinJoueurs(1);
            jeuInitial1.setDescription("Les joueurs tentent de coloniser une île grâce à une gestion stratégique des ressources et à un commerce fructueux. À chaque tour, les joueurs peuvent construire des colonies et des routes s'ils sont les ressources.");
            jeuInitial1.setTypes(typesJeuInitial1);
            jeuRepository.save(jeuInitial1);

            //Création jeuInitial 2
            Set<Type> typesJeuInitial2 = new HashSet<>();
            typesJeuInitial2.add(typeInitial18);
            typesJeuInitial2.add(typeInitial4);

            Jeu jeuInitial2 = new Jeu();
            jeuInitial2.setJeu("Indix");
            jeuInitial2.setNbreMaxJoueurs(6);
            jeuInitial2.setNbreMinJoueurs(1);
            jeuInitial2.setDescription("INDIX est un jeu pour adultes et adolescents. La règle de jeu est très simple. Chaque joueur devra faire preuve de connaissances et de perspicacité pour découvrir une identité en utilisant le moins d'indices possible.");
            jeuInitial2.setTypes(typesJeuInitial2);
            jeuRepository.save(jeuInitial2);

            //Création joueurInitial 1
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
