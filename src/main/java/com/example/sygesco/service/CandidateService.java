package com.example.sygesco.service;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.domain.Candidate;

import java.util.List;

public interface CandidateService {
    Candidate addCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    void deleteCandidateById(Long id);
    Candidate findCandidateById(Long id);
    Candidate updateCandidate(Candidate candidate);
}
