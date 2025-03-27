package com.example.demo.api.controller;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.api.model.jeu.GetJeuByJeu.GetJeuByJeuResponse;
import com.example.demo.bll.service.JeuService;
import com.example.demo.dal.domain.entity.Jeu;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/jeux")
public class JeuController {

    private final JeuService jeuService;

    @GetMapping ("")
    public ResponseEntity<Set<GetAllJeuxResponse>> getAllJeux () {
        HashSet<Jeu> setAllJeux = new HashSet<>(jeuService.getAllJeux());
        HashSet<GetAllJeuxResponse> setAllJeuxResponse = new HashSet<>();
        for (Jeu jeu : setAllJeux) {
            setAllJeuxResponse.add(new GetAllJeuxResponse(jeu));
        }
        return ResponseEntity.ok(setAllJeuxResponse);
    }

    @GetMapping ("/{jeu}")
    public ResponseEntity<GetJeuByJeuResponse> getJeuByJeu(@PathVariable String jeu) {
        return ResponseEntity.ok(jeuService.getJeuByJeu(jeu));
    }

    @PostMapping ("/create")
    public ResponseEntity<CreateJeuResponse> createJeu (@RequestBody CreateJeuRequest createJeuRequest){
        return ResponseEntity.ok(jeuService.createJeu(createJeuRequest));
    }
}

