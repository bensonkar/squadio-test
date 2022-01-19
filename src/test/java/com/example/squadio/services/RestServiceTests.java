package com.example.squadio.services;

import com.example.squadio.entities.Accounts;
import com.example.squadio.entities.StatementRequest;
import com.example.squadio.entities.Statements;
import com.example.squadio.entities.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RestServiceTests {

    @Autowired
    private RestService restService;

    @Test
    public void getAllUsersTests() {
        List<Users> users = restService.getAllUsers();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
    }

    @Test
    public void getUserDetailsTests() {
        Users user = restService.getUser("Mohamed");
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void getUserAccountsTests() {
        List<Accounts> accounts = restService.getAllUserAccounts("qbnKddlq70");
        Assertions.assertThat(accounts).hasSizeGreaterThan(0);
    }

    @Test
    public void getStatementsTests() {
        List<Statements> statements = restService.getAllAccountStatement(new StatementRequest("CbIJb0i3vQ"));
        Assertions.assertThat(statements).hasSizeGreaterThan(0);
    }

}
