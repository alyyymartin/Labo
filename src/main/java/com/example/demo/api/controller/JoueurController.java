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
        Joueur joueurCreated = joueurService.createJoueur(createJoueurRequest);
        return ResponseEntity.ok(new CreateJoueurResponse("Le joueur suivant a bien été créé : ", joueurCreated));
    }

    @GetMapping("/{username}")
    public ResponseEntity<GetByUsernameResponse> findJoueurByUsername(@PathVariable String username) {
        Joueur joueurToFind = joueurService.findJoueurByUsername(username);
        return ResponseEntity.ok(new GetByUsernameResponse("Voici les infos du joueur recherché : ", joueurToFind));
    }

    @GetMapping ("")
    public ResponseEntity<GetAllJoueursResponse> getAllJoueurs () {
        Set<Joueur> setAllJoueurs = new HashSet<>(joueurService.getAllJoueurs());
        return ResponseEntity.ok(new GetAllJoueursResponse(setAllJoueurs));
    }

    @DeleteMapping ("/{username}/delete")
    public ResponseEntity<DeleteJoueurByUsernameResponse> deleteJoueurByUsername (@PathVariable String username) {
        Joueur joueurDeleted = joueurService.deleteJoueurByUsername(username);
        return ResponseEntity.ok(new DeleteJoueurByUsernameResponse("Le joueur suivant a bien été supprimé : ", joueurDeleted));
    }

    @PutMapping("/{username}/update")
    public ResponseEntity<UpdateJoueurByUsernameResponse> updateJoueurByUsername(@PathVariable String username, @RequestBody UpdateJoueurByUsernameRequest updateJoueurByUsernameRequest) {

        Joueur joueurToUpdate = joueurService.findJoueurByUsername(username);
        Joueur joueurUpdated = joueurService.updateJoueurByUsername(username, updateJoueurByUsernameRequest);

        return ResponseEntity.ok(new UpdateJoueurByUsernameResponse(
                "Anciennes données du joueur ", joueurToUpdate,
                "Nouvelles données : ", joueurUpdated));
    }

}
