package com.example.sygesco.api;

import com.example.sygesco.domain.Candidate;
import com.example.sygesco.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getUserById(@PathVariable("id") Long id){
        Candidate user = candidateService.findCandidateById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppUserById(@PathVariable("id") Long id){
        candidateService.deleteCandidateById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Candidate> updateAppUser(@RequestBody Candidate cand) {
        Candidate candidate = candidateService.updateCandidate(cand);
        return new ResponseEntity<>(candidate,HttpStatus.OK );
    }
}
