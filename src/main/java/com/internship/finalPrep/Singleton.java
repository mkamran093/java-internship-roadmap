package com.internship.finalPrep;

public class Singleton {

    public static void main(String[] args) {

        ConfigManager config1 = ConfigManager.getInstance();
        ConfigManager config2 = ConfigManager.getInstance();

        System.out.println("Same instance? " + (config2 == config1));

        config1.set("app.name", "intern Tracker");
        System.out.println("app.name: " + config2.get("app.name"));
    }
}
