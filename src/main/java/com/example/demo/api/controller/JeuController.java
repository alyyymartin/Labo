package com.example.demo.api.controller;

import com.example.demo.api.model.jeu.Create.CreateJeuRequest;
import com.example.demo.api.model.jeu.Create.CreateJeuResponse;
import com.example.demo.api.model.jeu.GetAll.GetAllJeuxResponse;
import com.example.demo.bll.service.JeuService;
import com.example.demo.bll.serviceImpl.JeuServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/jeux")
public class JeuController {

    private final JeuService jeuService;

//    @GetMapping ("")
//    public ResponseEntity<List<GetAllJeuxResponse>> getAllJeux () {
//        return ResponseEntity.ok(new ArrayList<>(jeuService.getAllJeux()));
//    }
//

    @PostMapping ("/create")
    public ResponseEntity<CreateJeuResponse> createJeu (@RequestBody CreateJeuRequest createJeuRequest){
        return ResponseEntity.ok(jeuService.createJeu(createJeuRequest));
    }
}

