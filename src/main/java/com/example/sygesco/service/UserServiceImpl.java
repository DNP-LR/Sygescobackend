package com.example.sygesco.service;

import com.example.sygesco.domain.AppUser;
import com.example.sygesco.domain.Role;
import com.example.sygesco.repo.RoleRepo;
import com.example.sygesco.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private RoleRepo roleRepo;

    @Override
    public AppUser addUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role addRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());

        return roleRepo.save(role);
    }

    @Override
    public List<AppUser> getAllUsers() {
        log.info("Fetching  All users {}");
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return null;
    }
}
