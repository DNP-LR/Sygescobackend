package com.example.sygesco.api;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.domain.Candidate;
import com.example.sygesco.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.GeneratedValue;
import java.net.URI;
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
    @PostMapping("/save")
    public ResponseEntity<Candidate> addUser(@RequestBody Candidate user) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("candidate/save").toUriString());
        return ResponseEntity.created(uri).body(candidateService.addCandidate(user));
    }
}
