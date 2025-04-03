package com.example.demo.api.controller;

import com.example.demo.api.model.partie.CreatePartie.CreatePartieRequest;
import com.example.demo.api.model.partie.CreatePartie.CreatePartieResponse;
import com.example.demo.bll.service.PartieService;
import com.example.demo.dal.domain.entity.Partie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
