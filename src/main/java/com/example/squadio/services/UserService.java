package com.example.squadio.services;

import com.example.squadio.entities.Authentication;
import com.example.squadio.entities.Permissions;
import com.example.squadio.repositories.AuthenticationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class UserService {
    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(AuthenticationRepository authenticationRepository, PasswordEncoder passwordEncoder) {
        this.authenticationRepository = authenticationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void insertAdmin() {
        Authentication authentication = authenticationRepository.findByUsername("Admin");
        if (authentication == null) {
            authentication = new Authentication();
            authentication.setUsername("Admin");
            authentication.setPassword(passwordEncoder.encode("admin"));
            authentication.setPermission(Permissions.ADMIN);
            authenticationRepository.save(authentication);
            log.info("**************created admin**************");
        }
    }

    @PostConstruct
    public void insertUsers() {
        Authentication user1 = authenticationRepository.findByUsername("Mohamed");
        Authentication user2 = authenticationRepository.findByUsername("John");
        Authentication user3 = authenticationRepository.findByUsername("Kumar");
        if (user1 == null) {
            user1 = new Authentication();
            user1.setUsername("Mohamed");
            user1.setPassword(passwordEncoder.encode("user"));
            user1.setPermission(Permissions.USER);
            user1.setUserId("qbnKddlq70");
            authenticationRepository.save(user1);
            log.info("***************user with username Mohamed has been created **********************");
        }
        if (user2 == null) {
            user2 = new Authentication();
            user2.setUsername("John");
            user2.setPassword(passwordEncoder.encode("user"));
            user2.setPermission(Permissions.USER);
            user1.setUserId("E1RYSQOjRt");
            authenticationRepository.save(user2);
            log.info("***************user with username John has been created **********************");
        }
        if (user3 == null) {
            user3 = new Authentication();
            user3.setUsername("Kumar");
            user3.setPassword(passwordEncoder.encode("user"));
            user3.setPermission(Permissions.USER);
            user1.setUserId("0PuRdHrJTh");
            authenticationRepository.save(user3);
            log.info("***************user with username Kumar has been created **********************");
        }
    }

    public Authentication getUserDerails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        if (username.isEmpty()) {
            return null;
        }

        return authenticationRepository.findByUsername(username);
    }
}
