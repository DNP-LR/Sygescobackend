package com.example.sygesco.repo;

import com.example.sygesco.domain.Concours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcoursRepo extends JpaRepository<Concours, Long> {
    Concours findConcoursById(Long id);
    void deleteConcoursById(Long id);
}
