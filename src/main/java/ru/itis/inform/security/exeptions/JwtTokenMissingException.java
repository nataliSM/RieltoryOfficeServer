package ru.itis.inform.security.exeptions;

/**
 * Created by acacuce on 12.05.17.
 */

import org.springframework.security.core.AuthenticationException;

/**
 * Thrown when token cannot be found in the request header
 * @author pascal alma
 */

public class JwtTokenMissingException extends AuthenticationException {
    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
