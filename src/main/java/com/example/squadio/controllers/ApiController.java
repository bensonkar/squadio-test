package com.example.squadio.controllers;

import com.example.squadio.entities.Accounts;
import com.example.squadio.entities.StatementRequest;
import com.example.squadio.entities.Statements;
import com.example.squadio.entities.Users;
import com.example.squadio.services.RestService;
import com.example.squadio.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ApiController {

    private final RestService restService;
    private final UserService userService;

    public ApiController(RestService restService, UserService userService) {
        this.restService = restService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        log.info("<<<<<<<<<<<<<<<<Initiating get all users controller >>>>>>>>>>>>>>>>>>>>");
        List<Users> users = restService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{name}")
    public ResponseEntity getUser(@PathVariable String name) {
        log.info("<<<<<<<<<<<<<<<<Initiating get user details controller >>>>>>>>>>>>>>>>>>>>");
        String userd = String.valueOf(userService.getUserDerails().getAuthorities().toArray()[0]);
        if (userd.equals("USER")) {
            if (!userService.getUserDerails().getUsername().equals(name)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
            }
        }
        Users user = restService.getUser(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/accounts/{userId}")
    public ResponseEntity getAllUserAccounts(@PathVariable String userId) {
        log.info("<<<<<<<<<<<<<<<<Initiating get all user accounts controller >>>>>>>>>>>>>>>>>>>>");
        String userd = String.valueOf(userService.getUserDerails().getAuthorities().toArray()[0]);
        if (userd.equals("USER")) {
            if (!userService.getUserDerails().getUserId().equals(userId)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
            }
        }
        List<Accounts> accounts = restService.getAllUserAccounts(userId);
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/accounts/statements")
    public ResponseEntity getAacountStatement(@RequestBody StatementRequest request) {
        log.info("<<<<<<<<<<<<<<<<Initiating get all account statement  controller >>>>>>>>>>>>>>>>>>>>");
        String userd = String.valueOf(userService.getUserDerails().getAuthorities().toArray()[0]);
        if (userd.equals("USER")) {
            if (!userService.getUserDerails().getUserId().equals(request.getAccountId())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized user");
            }
        }
        List<Statements> statements = restService.getAllAccountStatement(request);
        return ResponseEntity.ok(statements);
    }

}
