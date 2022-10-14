package com.example.sygesco.service;


import com.example.sygesco.domain.AppUser;
import com.example.sygesco.domain.Candidate;
import com.example.sygesco.repo.CandidateRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CandidateServiceImpl implements CandidateService{
    private final CandidateRepo candidateRepo;

    @Override
    public Candidate addCandidate(Candidate candidate) {
        log.info("Saving new user {} to the database", candidate.getEmail());
        return candidateRepo.save(candidate);
    }
    @Override
    public List<Candidate> getAllCandidates() {
        log.info("Fetching  All Candidates {}");
        return candidateRepo.findAll();
    }
    @Override
    public void deleteCandidateById(Long id) {
        candidateRepo.deleteCandidateById(id);
    }

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepo.findCandidateById(id);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }
}
