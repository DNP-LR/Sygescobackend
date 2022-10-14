package com.example.sygesco.api;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.hibernate.sql.Delete;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/users/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable("id") Long id){
        AppUser user = userService.findAppUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteAppUserById(@PathVariable("id") Long id){
        userService.deleteAppUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/users/update")
    public ResponseEntity<AppUser> updateAppUser(@RequestBody AppUser user) {
        AppUser appUser = userService.updateAppUser(user);
        return new ResponseEntity<>(appUser,HttpStatus.OK );
    }
}
