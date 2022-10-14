package com.example.sygesco.api;

import com.example.sygesco.domain.Candidate;
import com.example.sygesco.domain.Dossier;
import com.example.sygesco.service.CandidateService;
import com.example.sygesco.service.DossierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dossier")
public class DossierResource {
    private final DossierService dossierService;;
    @GetMapping("/all")
    public ResponseEntity<List<Dossier>> getAllCandidates() {
        return ResponseEntity.ok().body(dossierService.getAllDossier());
    }
    @PostMapping("/save")
    public ResponseEntity<Dossier> addUser(@RequestBody Dossier dossier) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("dossier/save").toUriString());
        return ResponseEntity.created(uri).body(dossierService.addDossier(dossier));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getUserById(@PathVariable("id") Long id){
        Dossier dossier = dossierService.findDossierById(id);
        return new ResponseEntity<>(dossier, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppUserById(@PathVariable("id") Long id){
        dossierService.deleteDossierById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Dossier> updateAppUser(@RequestBody Dossier doss) {
        Dossier dossier = dossierService.updateDossierById(doss);
        return new ResponseEntity<>(dossier,HttpStatus.OK );
    }
}
