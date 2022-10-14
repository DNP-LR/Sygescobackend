package com.example.sygesco.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id ;
    private String userName;
    private String userEmail;
    private String password;

    @ManyToMany
    private Collection<Role> roles = new ArrayList<>();
}
