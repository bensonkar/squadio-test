package com.example.squadio.services;

import com.example.squadio.entities.Accounts;
import com.example.squadio.entities.StatementRequest;
import com.example.squadio.entities.Statements;
import com.example.squadio.entities.Users;

import java.util.List;

public interface RestService {
    List<Users> getAllUsers();

    Users getUser(String name);

    List<Accounts> getAllUserAccounts(String userId);

    List<Statements> getAllAccountStatement(StatementRequest request);
}
