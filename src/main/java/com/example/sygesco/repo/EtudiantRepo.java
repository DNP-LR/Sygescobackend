package com.example.sygesco.repo;

import com.example.sygesco.domain.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {
    Etudiant findEtudiantById(Long id);
    void deleteEtudiantById(Long id);
}

