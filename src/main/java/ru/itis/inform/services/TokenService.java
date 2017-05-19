package ru.itis.inform.services;

import ru.itis.inform.security.models.AuthenticatedUser;

import java.util.Optional;


import ru.itis.inform.models.User;
import ru.itis.inform.security.models.AuthenticatedUser;

import java.util.Optional;

/**JwtTokenServiceImpl.java
 * Created by acacuce on 12.05.17.
 */
public interface TokenService {
    Optional<AuthenticatedUser> validateTokenString(String tokenString);
    String generateTokenString(User u);

}
