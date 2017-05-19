package ru.itis.inform.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.inform.security.exeptions.JwtTokenMalformedException;
import ru.itis.inform.security.models.AuthenticatedUser;
import ru.itis.inform.security.models.JwtAuthenticationToken;
import ru.itis.inform.services.TokenService;

/**
 * Created by acacuce on 11.05.17.
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String tokenString = jwtAuthenticationToken.getToken();

        AuthenticatedUser user = tokenService.validateTokenString(tokenString).orElseThrow(() -> {
            return new JwtTokenMalformedException("JWT token is not valid");
        });

        return  user;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
