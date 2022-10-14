package com.example.sygesco.api;
import com.example.sygesco.domain.Etudiant;
import com.example.sygesco.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantResource {
    private final EtudiantService etudiantService;;
    @GetMapping("/all")
    public ResponseEntity<List<Etudiant>>getAllEtutiant() {
        return ResponseEntity.ok().body(etudiantService.getAllEtudiant());
    }
    @PostMapping("/save")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("etudiant/save").toUriString());
        return ResponseEntity.created(uri).body(etudiantService.addEtudiant(etudiant));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getUserById(@PathVariable("id") Long id){
        Etudiant etudiant = etudiantService.findEtudiantById(id);
        return new ResponseEntity<>(etudiant, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppUserById(@PathVariable("id") Long id){
        etudiantService.deleteEtudianttById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Etudiant> updateAppUser(@RequestBody Etudiant etudiant) {
        Etudiant etudiant1 = etudiantService.updateEtudiant(etudiant);
        return new ResponseEntity<>(etudiant1,HttpStatus.OK );
    }
}
