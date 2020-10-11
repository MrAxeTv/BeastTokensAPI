package me.mraxetv.beasttokens.api;

public enum DropType {
    BLOCKS("Blocks"),
    FARMING("Farming"),
    MOBS("Mobs"),
    MYTHIC_MOBS("MythicMobs");

    private String path;

    private DropType(String path) {
        this.path = path;
    }

    public String getName(){
        return path;
    }


}
