package com.internship.finalPrep;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalMail {

    public static String getEmail(
            Map<String, Optional<String>> userEmails,
            String username
    ) {

        return userEmails
                .getOrDefault(username, Optional.empty())
                .map(email -> "Email: " + email)
                .orElse("No email found");
    }

    static void main(String[] args) {

        Map<String, Optional<String>> userEmails = new HashMap<>();

        userEmails.put("alice", Optional.of("lskjflsjaljg"));
        userEmails.put("bob", Optional.of("soidj9"));
        userEmails.put("martha", Optional.of("fij4ihsl"));

        System.out.println(getEmail(userEmails, "alice"));
        System.out.println(getEmail(userEmails, "ed"));

    }
}
