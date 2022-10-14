package com.example.sygesco.service;

import com.example.sygesco.domain.Dossier;

import java.util.List;


public interface DossierService {
    Dossier addDossier(Dossier dossier);
    List<Dossier> getAllDossier();
    void deleteDossierById(Long id);
    Dossier findDossierById(Long id);
    Dossier updateDossierById(Dossier dossier);

}
