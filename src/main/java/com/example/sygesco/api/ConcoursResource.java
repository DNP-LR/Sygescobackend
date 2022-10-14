package com.example.sygesco.api;

import com.example.sygesco.domain.Candidate;
import com.example.sygesco.domain.Concours;
import com.example.sygesco.repo.ConcoursRepo;
import com.example.sygesco.service.ConcoursService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/concours")
public class ConcoursResource {
    private final ConcoursService concoursService;
    @GetMapping("/all")
    public ResponseEntity<List<Concours>> getAllConcours() {
        return ResponseEntity.ok().body(concoursService.getAllConcours());
    }
    @PostMapping("/save")
    public ResponseEntity<Concours> addUser(@RequestBody Concours concours) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("concours/save").toUriString());
        return ResponseEntity.created(uri).body(concoursService.addCandidate(concours));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Concours> getUserById(@PathVariable("id") Long id){
        Concours concours = concoursService.findConcoursById(id);
        return new ResponseEntity<>(concours, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConcoursById(@PathVariable("id") Long id){
        concoursService.deleteConcoursById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Concours> updateCandidate(@RequestBody Concours concours) {
        Concours concours1 = concoursService.updateConcours(concours);
        return new ResponseEntity<>(concours1,HttpStatus.OK );
    }
}
