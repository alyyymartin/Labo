package com.example.demo.api.controller;

import com.example.demo.api.model.partie.CreatePartie.CreatePartieRequest;
import com.example.demo.api.model.partie.CreatePartie.CreatePartieResponse;
import com.example.demo.api.model.partie.GetAllPartiesByJeuByJoueur.GetAllPartiesByJeuByJoueurRequest;
import com.example.demo.api.model.partie.GetAllPartiesByJeuByJoueur.GetAllPartiesByJeuByJoueurResponse;
import com.example.demo.bll.service.PartieService;
import com.example.demo.dal.domain.entity.Partie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parties")
public class PartieController {

    private final PartieService partieService;

    @PostMapping("/{jeu}/create")
    public ResponseEntity<CreatePartieResponse> createJeu (@PathVariable String jeu, @RequestBody CreatePartieRequest createPartieRequest){
        Partie createdPartie = partieService.createPartie(createPartieRequest);
        return ResponseEntity.ok(new CreatePartieResponse("Une partie de %s a bien été créée : ", createdPartie));
    }

    @GetMapping ("/{jeu}/filterByJoueur")
    public ResponseEntity<GetAllPartiesByJeuByJoueurResponse> getAllPartiesByJeuByJoueur(@PathVariable String jeu, @RequestBody GetAllPartiesByJeuByJoueurRequest getAllPartiesByJeuByJoueurRequest){
        List<Partie> listAllPartiesByJeuByJoueur = new ArrayList<>(partieService.getAllPartiesByJeuByJoueur(jeu, getAllPartiesByJeuByJoueurRequest.joueur()));
        GetAllPartiesByJeuByJoueurResponse getAllPartiesByJeuByJoueurResponse = new GetAllPartiesByJeuByJoueurResponse(listAllPartiesByJeuByJoueur);
        return ResponseEntity.ok(getAllPartiesByJeuByJoueurResponse);
    }


}
