package com.example.sygesco.service;

import com.example.sygesco.domain.Dossier;
import com.example.sygesco.repo.DossierRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DossierServiceImpl implements DossierService{
private final DossierRepo dossierRepo;

    @Override
    public Dossier addDossier(Dossier dossier) {
        log.info("Saving new Dossier {} to the database", dossier.getLibelle());
        return dossierRepo.save(dossier);
    }
    @Override
    public List<Dossier> getAllDossier() {
        log.info("Fetching  All Dossier {}");
        return dossierRepo.findAll();
    }
    @Override
    public void deleteDossierById(Long id) {
        dossierRepo.deleteDossierById(id);
    }
    @Override
    public Dossier findDossierById(Long id) {
        return dossierRepo.findDossierById(id);
    }
    @Override
    public Dossier updateDossierById(Dossier dossier) {
        return dossierRepo.save(dossier);
    }
}
