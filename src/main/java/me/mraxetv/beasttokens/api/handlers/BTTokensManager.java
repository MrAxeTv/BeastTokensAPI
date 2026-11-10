package me.mraxetv.beasttokens.api.handlers;

import me.mraxetv.beasttokens.api.StorageType;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public interface BTTokensManager {
  boolean isLoaded(OfflinePlayer paramOfflinePlayer);
  
  void saveTokens(Player paramPlayer, boolean unLoad);
  void saveTokens(Player paramPlayer, boolean unLoad,boolean async);

  double getMaxTokens();
  
  boolean hasMaxTokens(Player paramPlayer);
  
  void setTokens(Player paramPlayer, double paramDouble);

  default void setTokens(Player paramPlayer, double paramDouble, BTTransactionReason reason) {
    setTokens(paramPlayer, paramDouble);
  }
  
  void setTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);

  default void setTokens(OfflinePlayer paramOfflinePlayer, double paramDouble, BTTransactionReason reason) {
    setTokens(paramOfflinePlayer, paramDouble);
  }
  
  void addTokens(Player paramPlayer, double paramDouble);

  default void addTokens(Player paramPlayer, double paramDouble, BTTransactionReason reason) {
    addTokens(paramPlayer, paramDouble);
  }
  
  void addTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);

  default void addTokens(OfflinePlayer paramOfflinePlayer, double paramDouble, BTTransactionReason reason) {
    addTokens(paramOfflinePlayer, paramDouble);
  }
  
  void removeTokens(Player paramPlayer, double paramDouble);

  default void removeTokens(Player paramPlayer, double paramDouble, BTTransactionReason reason) {
    removeTokens(paramPlayer, paramDouble);
  }
  
  void removeTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);

  default void removeTokens(OfflinePlayer paramOfflinePlayer, double paramDouble, BTTransactionReason reason) {
    removeTokens(paramOfflinePlayer, paramDouble);
  }
  
  double getTokens(Player paramPlayer);
  
  double getTokens(OfflinePlayer paramOfflinePlayer);
  
  void loadPlayer(Player paramPlayer);
  
  void unLoadPlayer(Player paramPlayer);
  
  void unLoadPlayer(UUID paramUUID);
  
  ArrayList<String> getTopPlayers();
  
  ItemStack getTokenNote(String paramString, double paramDouble, int paramInt, boolean paramBoolean);
  
  void saveAll(boolean async);
  
  double getStartAmount();

  int convertData(StorageType storageType);

  HashMap<UUID, Double> getAllPlayersBalance();

  double getTotalSpentTokens(String name);

}
