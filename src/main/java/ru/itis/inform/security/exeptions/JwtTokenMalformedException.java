package ru.itis.inform.security.exeptions;

/**
 * Created by acacuce on 12.05.17.
 */

import org.springframework.security.core.AuthenticationException;

/**
 * Thrown when token cannot be parsed
 * @author pascal alma
 */
public class JwtTokenMalformedException extends AuthenticationException {

    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
