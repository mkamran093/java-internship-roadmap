package com.internship.finalPrep;

interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(
                "[EMAIL] " + message
        );
    }
}

class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println(
                "[SMS] " + message
        );
    }
}

class NotificationFactory {

    public static Notification create(String type) {

        return switch (type.toLowerCase()) {
            case "email" ->
                new EmailNotification();

            case "sms" ->
                new SMSNotification();

            default ->
                throw new IllegalArgumentException(
                        "Unknown Notification type: " +
                                type
                );
        };
    }
}

public class Notify {

    public static void createAndPrint(String type) {

        try {
            Notification notification = NotificationFactory.create(type);

            System.out.println("Created " + notification.getClass().getSimpleName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        createAndPrint("Email");
        createAndPrint("SmS");
        createAndPrint("Fax");

    }

}