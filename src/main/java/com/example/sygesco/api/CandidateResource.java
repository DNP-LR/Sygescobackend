package com.example.sygesco.api;

import com.example.sygesco.domain.Candidate;
import com.example.sygesco.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candidate")
public class CandidateResource {
    private final CandidateService candidateService;;

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>>getAllCandidates() {
        return ResponseEntity.ok().body(candidateService.getAllCandidates());

    }
}
