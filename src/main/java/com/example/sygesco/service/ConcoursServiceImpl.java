package com.example.sygesco.service;

import com.example.sygesco.domain.Concours;
import com.example.sygesco.repo.CandidateRepo;
import com.example.sygesco.repo.ConcoursRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ConcoursServiceImpl implements ConcoursService{
    private final ConcoursRepo concoursRepo;
    @Override
    public Concours addCandidate(Concours concours) {
        log.info("Saving new Concours {} to the database", concours.getId());
        return concoursRepo.save(concours);
    }

    @Override
    public List<Concours> getAllConcours() {
        return concoursRepo.findAll();
    }

    @Override
    public void deleteConcoursById(Long id) {
        concoursRepo.deleteConcoursById(id);
    }

    @Override
    public Concours findConcoursById(Long id) {
        return concoursRepo.findConcoursById(id);
    }

    @Override
    public Concours updateConcours(Concours concours) {
        return concoursRepo.save(concours);
    }
}
