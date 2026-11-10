package me.mraxetv.beasttokens.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public enum StorageType {
    FILE("File"),
    MYSQL("Mysql"),
    SQLITE("SQLite"),
    TOKEN_ENCHANT("TokenEnchant");

    private final String name;

    /**
     * @deprecated Use {@link #getNames()} for a read-only collection.
     */
    @Deprecated
    public static final HashSet<String> list = new HashSet<>();
    private static final List<String> names;

    static {
        List<String> configuredNames = new ArrayList<>();
        for (StorageType storageType : StorageType.values()) {
            list.add(storageType.name);
            configuredNames.add(storageType.name);
        }
        names = Collections.unmodifiableList(configuredNames);
    }

    StorageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getConfigName() {
        return name;
    }

    public static List<String> getNames() {
        return names;
    }

    public static StorageType fromString(String stringRepresentation) {
        if (stringRepresentation == null || stringRepresentation.trim().isEmpty()) return null;

        String normalized = stringRepresentation.trim()
                .replace("-", "")
                .replace("_", "")
                .replace(" ", "")
                .toLowerCase(Locale.ENGLISH);

        if (normalized.equals("file") || normalized.equals("yaml") || normalized.equals("yml")) return FILE;
        if (normalized.equals("mysql") || normalized.equals("sql")) return MYSQL;
        if (normalized.equals("sqlite") || normalized.equals("sqlite3") || normalized.equals("localdb")
                || normalized.equals("localdatabase") || normalized.equals("databasefile")) return SQLITE;
        if (normalized.equals("tokenenchant") || normalized.equals("tenchant")) return TOKEN_ENCHANT;
        return null;
    }

    public static StorageType fromString(String value, StorageType fallback) {
        StorageType type = fromString(value);
        return type == null ? fallback : type;
    }
}
