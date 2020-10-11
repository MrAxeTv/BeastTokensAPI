package me.mraxetv.beasttokens.api.wrappers.boosters;

import me.mraxetv.beasttokens.api.DropType;

public interface ChanceBoosterManager {
    double getPercentageBooster(DropType type);

    double getMultiplierBooster(DropType type);

    boolean hasPercentageBooster(DropType type);

    boolean hasMultiplierBooster(DropType type);
}
