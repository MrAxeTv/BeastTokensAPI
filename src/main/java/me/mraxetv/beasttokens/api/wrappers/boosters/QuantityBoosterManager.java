package me.mraxetv.beasttokens.api.wrappers.boosters;

//import me.mraxetv.beasttokens.api.DropType;

import me.mraxetv.beasttokens.api.DropType;

public interface QuantityBoosterManager {
  double getPercentageBooster(DropType paramDropType);
  
  double getMultiplierBooster(DropType paramDropType);
  
  boolean hasPercentageBooster(DropType paramDropType);
  
  boolean hasMultiplierBooster(DropType paramDropType);
}
