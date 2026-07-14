package com.internship.week2.day2;

public class OTPAuthenticator implements Authenticator {

    @Override
    public boolean authenticate(String credential) {
        return credential.equals("123456");
    }
}
