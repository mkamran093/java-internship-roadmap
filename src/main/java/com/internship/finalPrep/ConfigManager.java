package com.internship.finalPrep;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private static final ConfigManager INSTANCE = new ConfigManager();

    private final Map<String, String> settings = new HashMap<>();

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }

    public String get(String key) {
        return settings.get(key);
    }

}
