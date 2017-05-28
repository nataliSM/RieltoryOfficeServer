package ru.itis.inform.services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import ru.itis.inform.models.User;
import ru.itis.inform.security.models.AuthenticatedUser;
import ru.itis.inform.services.TokenService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by acacuce on 12.05.17.
 */
@Component
public class JwtTokenServiceImpl implements TokenService {

    @Value("${jwt.secret}")
    private String secret;
    private final String USER_ID_KEY = "userId";
    private final String ROLE_KEY = "role";
    private final Integer EXPIRATION_DATE_STAMP = 10;



    public Optional<AuthenticatedUser> validateTokenString(String tokenString) {
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(tokenString)
                    .getBody();

            if (new Date().after(body.getExpiration())) {
                return Optional.empty();
            }
            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList((String)body.get(ROLE_KEY));
            Long id = Long.parseLong(body.getId());
            AuthenticatedUser u = new AuthenticatedUser(id, body.getSubject(),tokenString, authorityList);

            return Optional.of(u);

        } catch (JwtException | ClassCastException e) {
            return Optional.empty();
        }
    }

    /**
     * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
     * User object. Tokens validity is infinite.
     *
     * @param u the user for which the token will be generated
     * @return the JWT token
     */
    public String generateTokenString(User u) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRATION_DATE_STAMP);
        Claims claims = Jwts.claims().setSubject(u.getUsername());
        claims.setId(u.getId().toString());
        claims.put(ROLE_KEY, u.getRole());
        claims.setExpiration(calendar.getTime());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
