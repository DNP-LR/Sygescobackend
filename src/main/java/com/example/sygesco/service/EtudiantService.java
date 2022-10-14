package com.example.sygesco.service;

import com.example.sygesco.domain.Etudiant;
import java.util.List;

public interface EtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiant();
    void deleteEtudianttById(Long id);
    Etudiant findEtudiantById(Long id);
    Etudiant updateEtudiant(Etudiant etudiant);
}
