package com.example.sygesco.service;

import com.example.sygesco.domain.Etudiant;
import com.example.sygesco.repo.EtudiantRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepo etudiantRepo;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepo.findAll();
    }

    @Override
    public void deleteEtudianttById(Long id) {
        etudiantRepo.deleteEtudiantById(id);
    }

    @Override
    public Etudiant findEtudiantById(Long id) {
        return etudiantRepo.findEtudiantById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }
}
