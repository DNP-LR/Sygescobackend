package com.example.sygesco.api;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class UserResource {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>>getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/users/save")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/save").toUriString());
        return ResponseEntity.created(uri).body(userService.addUser(user));
    }
}
