package com.example.sygesco.repo;

import com.example.sygesco.domain.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    Candidate findCandidateById(Long id);
    void deleteCandidateById(Long id);
}
