package com.example.demo.api.controller;

import com.example.demo.api.model.joueur.Create.CreateJoueurRequest;
import com.example.demo.api.model.joueur.Create.CreateJoueurResponse;
import com.example.demo.api.model.joueur.DeleteByUsername.DeleteJoueurByUsernameResponse;
import com.example.demo.api.model.joueur.GetAll.GetAllJoueursResponse;
import com.example.demo.api.model.joueur.GetByUsername.GetByUsernameResponse;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameRequest;
import com.example.demo.api.model.joueur.Update.UpdateJoueurByUsernameResponse;
import com.example.demo.bll.service.JoueurService;
import com.example.demo.dal.domain.entity.Joueur;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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
    public ResponseEntity<GetByUsernameResponse> findJoueurByUsername(@PathVariable String username) {
        return ResponseEntity.ok(joueurService.findJoueurByUsername(username));
    }

    @GetMapping ("")
    public ResponseEntity<GetAllJoueursResponse> getAllJoueurs () {
        return ResponseEntity.ok(joueurService.getAllJoueurs());
    }

    @DeleteMapping ("/{username}/delete")
    public ResponseEntity<DeleteJoueurByUsernameResponse> deleteJoueurByUsername (@PathVariable String username) {
        return ResponseEntity.ok(joueurService.deleteJoueurByUsername(username));
    }

    @PutMapping("/{username}/update")
    public ResponseEntity<UpdateJoueurByUsernameResponse> updateJoueurByUserame(@PathVariable String username, @RequestBody UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest) {
        return ResponseEntity.ok(joueurService.updateJoueurByUsername(username, updateJoueurByUsernameRequest));
    }

}
