package com.example.squadio.services.impl;

import com.example.squadio.entities.Accounts;
import com.example.squadio.entities.StatementRequest;
import com.example.squadio.entities.Statements;
import com.example.squadio.entities.Users;
import com.example.squadio.exceptions.ApplicationException;
import com.example.squadio.services.MyRestTemplate;
import com.example.squadio.services.RestService;
import com.example.squadio.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class RestServiceImpl implements RestService {

    private final MyRestTemplate restTemplate;
    private final UserService userService;
    @Value("${remote.rest.endpoint}")
    String url;

    public RestServiceImpl(MyRestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @Override
    public List<Users> getAllUsers() {
        RestTemplate template = restTemplate.disabledSSLTemplate();
        HttpHeaders headers = restTemplate.getAuthorizationHeaders();
        HttpEntity<Users> httpEntity = new HttpEntity<>(headers);
        try {
            final List<Users> users = template.exchange(url + "users", HttpMethod.GET, httpEntity, List.class).getBody();
            log.info("****************Response for getting all users ************** {}", users);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(">>>>>>>>>>>>>>>>>>>>>>Error occurred for getting all users: {}", e.getMessage());
            throw new ApplicationException("Error while getting users", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Users getUser(String name) {
        RestTemplate template = restTemplate.disabledSSLTemplate();
        HttpHeaders headers = restTemplate.getAuthorizationHeaders();
        HttpEntity<Users> httpEntity = new HttpEntity<>(headers);
        try {
            final Users user = template.exchange(url + "users/".concat(name), HttpMethod.GET, httpEntity, Users.class).getBody();
            log.info("****************Response for getting user details ************** {}", user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(">>>>>>>>>>>>>>>>>>>>>>Error occurred for getting user details: {}", e.getMessage());
            throw new ApplicationException("Error while getting user details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Accounts> getAllUserAccounts(String userId) {
        RestTemplate template = restTemplate.disabledSSLTemplate();
        HttpHeaders headers = restTemplate.getAuthorizationHeaders();
        HttpEntity<Users> httpEntity = new HttpEntity<>(headers);
        try {
            final List<Accounts> accounts = template.exchange(url + "accounts/".concat(userId), HttpMethod.GET, httpEntity, List.class).getBody();
            log.info("****************Response for getting all user account ************** {}", accounts);
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(">>>>>>>>>>>>>>>>>>>>>>Error occurred for getting all user account: {}", e.getMessage());
            throw new ApplicationException("Error while getting all user account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Statements> getAllAccountStatement(StatementRequest request) {
        RestTemplate template = restTemplate.disabledSSLTemplate();
        HttpHeaders headers = restTemplate.getAuthorizationHeaders();
        HttpEntity<StatementRequest> httpEntity = new HttpEntity<>(request, headers);
        try {
            final List<Statements> statements = template.exchange(url + "accounts/statements", HttpMethod.POST, httpEntity, List.class).getBody();
            log.info("****************Response for getting all account statement ************** {}", statements);
            return statements;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(">>>>>>>>>>>>>>>>>>>>>>Error occurred for getting all account statement: {}", e.getMessage());
            throw new ApplicationException("Error while getting all account statement", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
