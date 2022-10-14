package com.example.sygesco.repo;

import com.example.sygesco.domain.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierRepo extends JpaRepository<Dossier, Long> {
    Dossier findDossierById(Long id);

    void deleteDossierById(Long id);
}
