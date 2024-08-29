package me.mraxetv.beasttokens.api;

public enum DropType {
  MINING("Mining"),
  FARMING("Farming"),
  FISHING("Fishing"),
  PLAYER("Player"),
  MOBS("Mobs"),
  MYTHIC_MOBS("MythicMobs");
  
  private String path;
  
  DropType(String path) {
    this.path = path;
  }
  
  public String getName() {
    return this.path;
  }
}
