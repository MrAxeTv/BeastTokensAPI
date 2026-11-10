package me.mraxetv.beasttokens.api;

import java.util.Locale;

public enum StockType {
  PLAYER("Player", "Stock limit per player"),
  SERVER("Server", "Stock limit shared by the server or network");

  private final String configName;
  private final String description;

  StockType(String configName, String description) {
    this.configName = configName;
    this.description = description;
  }

  public String getConfigName() {
    return configName;
  }

  public String getName() {
    return configName;
  }

  public String getDescription() {
    return description;
  }

  public static StockType fromString(String value) {
    if (value == null || value.trim().isEmpty()) return null;

    String normalized = value.trim()
        .replace("-", "")
        .replace("_", "")
        .replace(" ", "")
        .toLowerCase(Locale.ENGLISH);

    if (normalized.equals("player") || normalized.equals("perplayer")) return PLAYER;
    if (normalized.equals("server") || normalized.equals("global") || normalized.equals("network")) return SERVER;
    return null;
  }

  public static StockType fromString(String value, StockType fallback) {
    StockType type = fromString(value);
    return type == null ? fallback : type;
  }
}
