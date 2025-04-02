package com.example.demo.api.controller;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.DeleteJeuByJeu.DeleteJeuByJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.api.model.jeu.GetAllJeuxByType.GetAllJeuxByTypeResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/jeux")
public class JeuController {

    private final JeuService jeuService;

    @GetMapping ("")
    public ResponseEntity<GetAllJeuxResponse> getAllJeux () {
        HashSet<Jeu> setAllJeux = new HashSet<>(jeuService.getAllJeux());
        GetAllJeuxResponse getAllJeuxResponse = new GetAllJeuxResponse(setAllJeux);
        return ResponseEntity.ok(getAllJeuxResponse);
    }

    @GetMapping ("/{jeu}/jeu")
    public ResponseEntity<GetJeuByJeuResponse> getJeuByJeu(@PathVariable String jeu) {
        return ResponseEntity.ok(jeuService.getJeuByJeu(jeu));
    }

    @GetMapping("/{type}")
    public ResponseEntity<GetAllJeuxByTypeResponse> getAllJeuxByType(@PathVariable String type) {
        List<Jeu> listAllJeuxByType = new ArrayList<>(jeuService.getJeuxByType(type));
        GetAllJeuxByTypeResponse allJeuxByTypeResponse = new GetAllJeuxByTypeResponse(listAllJeuxByType);
        return ResponseEntity.ok(allJeuxByTypeResponse);
    }

    @PostMapping ("/create")
    public ResponseEntity<CreateJeuResponse> createJeu (@RequestBody CreateJeuRequest createJeuRequest){
        Jeu createdGame = jeuService.createJeu(createJeuRequest);
        return ResponseEntity.ok(new CreateJeuResponse("Le jeu suivant a bien été créé : ", createdGame));
    }

    @DeleteMapping ("/{jeu}/delete")
    public ResponseEntity<DeleteJeuByJeuResponse> deleteJeuByJeu (@PathVariable String jeu) {
        return ResponseEntity.ok(jeuService.deleteJeuByJeu(jeu));
    }
}

