package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.inform.services.UsersService;

/**
 * Created by acacuce on 12.05.17.
 */
@RestController

public class LoginController {
    @Value("${jwt.header}")
    private String tokenHeader;


    @Autowired
    private UsersService usersService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader("password") String password,
                                        @RequestHeader("username") String login) {
        String token = usersService.login(password, login);
        HttpHeaders headers = new HttpHeaders();
        headers.add(tokenHeader, token);
        return new ResponseEntity<>(null, headers, HttpStatus.OK);
    }

}
