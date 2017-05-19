package ru.itis.inform.security.models;

import ru.itis.inform.models.User;

import java.util.Date;

/**
 * Created by acacuce on 12.05.17.
 */
public class Token {
    private User user;
    private Date expirationDate;
    private String issuer;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
