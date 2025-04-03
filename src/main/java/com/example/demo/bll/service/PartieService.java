package com.example.demo.bll.service;

import com.example.demo.api.model.partie.CreatePartie.CreatePartieRequest;
import com.example.demo.dal.domain.entity.Partie;

public interface PartieService {

    Partie createPartie(CreatePartieRequest createPartieRequest);
}
