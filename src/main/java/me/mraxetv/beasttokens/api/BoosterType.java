package me.mraxetv.beasttokens.api;

public enum BoosterType {

    QUANTITY_MULTIPLIER_BOOSTER("Multiplier"),
    QUANTITY_PERCENTAGE_BOOSTER("Percentage"),
    CHANCE_MULTIPLIER_BOOSTER("Multiplier"),
    CHANCE_PERCENTAGE_BOOSTER("Percentage");

    private String name;

    private BoosterType(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
