package com.example.sygesco.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String noms;
    private String prenoms;
    private String email;
    private String dateDeNaissance;
    private String lieuDeNaissance;
    private String adressePermanent;
    private String nationalite;
    private String situationMatrimonial;
    private String image;
    private String regionDorigine;
    private String niveau;
    private String filiere;
    private Long numCNI;
    private String statusEdudiant;
}
