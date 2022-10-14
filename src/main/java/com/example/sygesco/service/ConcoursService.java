package com.example.sygesco.service;

import com.example.sygesco.domain.Concours;

import java.util.List;

public interface ConcoursService {
    Concours addCandidate(Concours concours);
    List< Concours> getAllConcours();
    void deleteConcoursById(Long id);
    Concours findConcoursById(Long id);
    Concours updateConcours( Concours concours);
}
