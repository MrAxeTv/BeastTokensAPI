package me.mraxetv.beasttokens.api;

import java.util.HashSet;

public enum StorageType {
    FILE("File"),
    MYSQL("Mysql"),
    TOKEN_ENCHANT("TokenEnchant");


    private String name;

    public static HashSet<String> list = new HashSet<>();

    static {
        for (StorageType storageType : StorageType.values()) {
            list.add(storageType.name);
        }
    }

    StorageType(String name) {
        this.name = name;

    }

    public String getName(){
        return name;
    }
    public static StorageType fromString(String stringRepresentation) {
        for (StorageType storageType : StorageType.values()) {
            if (storageType.name.equalsIgnoreCase(stringRepresentation)) {
                return storageType;
            }
        }

        return null;
        //throw new IllegalArgumentException("Invalid StorageType: " + stringRepresentation);
    }


}
