package me.mraxetv.beasttokens.api.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import me.mraxetv.beasttokens.api.StorageType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface BTTokensManager {
  boolean isLoaded(OfflinePlayer paramOfflinePlayer);
  
  void saveTokens(Player paramPlayer, boolean paramBoolean);
  
  double getMaxTokens();
  
  boolean hasMaxTokens(Player paramPlayer);
  
  void setTokens(Player paramPlayer, double paramDouble);
  
  void setTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);
  
  void addTokens(Player paramPlayer, double paramDouble);
  
  void addTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);
  
  void removeTokens(Player paramPlayer, double paramDouble);
  
  void removeTokens(OfflinePlayer paramOfflinePlayer, double paramDouble);
  
  double getTokens(Player paramPlayer);
  
  double getTokens(OfflinePlayer paramOfflinePlayer);
  
  void loadPlayer(Player paramPlayer);
  
  void unLoadPlayer(Player paramPlayer);
  
  void unLoadPlayer(UUID paramUUID);
  
  ArrayList<String> getTopPlayers();
  
  ItemStack getTokenNote(String paramString, double paramDouble, int paramInt, boolean paramBoolean);
  
  void saveAll();
  
  double getStartAmount();

  int convertData(StorageType storageType);

  HashMap<UUID, Double> getAllPlayersBalance();

  double getTotalSpentTokens(String name);

}
