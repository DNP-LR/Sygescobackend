package com.example.sygesco.service;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.domain.Role;

import java.util.List;

public interface UserService {
    AppUser addUser(AppUser user);
    Role addRole(Role role);
    List<AppUser> getAllUsers();
    void deleteAppUserById(Long id);
    AppUser findAppUserById(Long id);

    AppUser updateAppUser(AppUser user);
}
