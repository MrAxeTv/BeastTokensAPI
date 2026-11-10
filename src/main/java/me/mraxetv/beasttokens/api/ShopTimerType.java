package me.mraxetv.beasttokens.api;

import java.util.Locale;

public enum ShopTimerType {
    CYCLE("CYCLE"),
    TIMESTAMP("TIMESTAMP"),
    UNKNOWN("UNKNOWN");

    private final String configName;

    ShopTimerType(String configName) {
        this.configName = configName;
    }

    public String getName() {
        return configName;
    }

    public String getConfigName() {
        return configName;
    }

    public static ShopTimerType fromString(String value) {
        if (value == null || value.trim().isEmpty()) return UNKNOWN;

        String normalized = value.trim()
                .replace("-", "")
                .replace("_", "")
                .replace(" ", "")
                .toLowerCase(Locale.ENGLISH);

        if (normalized.equals("cycle") || normalized.equals("interval")) return CYCLE;
        if (normalized.equals("timestamp") || normalized.equals("scheduled") || normalized.equals("schedule")) {
            return TIMESTAMP;
        }
        return UNKNOWN;
    }

    public static ShopTimerType getByName(String value) {
        return fromString(value);
    }
}
