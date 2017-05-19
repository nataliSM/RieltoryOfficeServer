package ru.itis.inform.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.models.User;
import ru.itis.inform.security.utils.Role;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.UsersService;

/**
 * Created by acacuce on 12.05.17.
 */
@Component
public class UsersServiceImpl implements UsersService{
    @Autowired
    TokenService tokenService;

    @Override
    public String login(String password, String login) {
        User user = new User();
        user.setEmail("example@mail.com");
        user.setId((long) 2);
        user.setRole(Role.USER.toString());
        user.setUsername("example");
        return tokenService.generateTokenString(user);
    }
}
