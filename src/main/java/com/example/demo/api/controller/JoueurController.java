package com.example.demo.api.controller;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.bll.service.JoueurService;
import com.example.demo.dal.domain.entity.Joueur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/joueurs")
public class JoueurController {

    private final JoueurService joueurService;

    @PostMapping("/create")
    public ResponseEntity<CreateJoueurResponse> createJoueur(@RequestBody CreateJoueurRequest createJoueurRequest) {
        return ResponseEntity.ok(joueurService.createJoueur(createJoueurRequest));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Joueur> findJoueurByUsername(@PathVariable String username) {
        return ResponseEntity.ok(joueurService.findJoueurByUsername(username));
    }


}
