package com.internship.week2.day2;

public class PasswordAuthenticator implements Authenticator {

    @Override
    public boolean authenticate(String credential) {
        return credential.equals("admin123");
    }
}
