package me.mraxetv.beasttokens.api.wrappers.player;

import me.mraxetv.beasttokens.api.wrappers.shop.BTShopData;
import me.mraxetv.beasttokens.api.wrappers.boosters.ChanceBoosterManager;
import me.mraxetv.beasttokens.api.wrappers.boosters.QuantityBoosterManager;
import me.mraxetv.beasttokens.api.wrappers.shop.BTShopView;
import org.bukkit.entity.Player;

public interface BTPlayer extends BTOfflinePlayer {
  Player getPlayer();
  
  boolean hasOpenShop();
  
  BTShopView getShopView();
  
  BTShopData getShop();
  
  String getShopName();
  
  void openShop(String paramString);
  
  void openShop(BTShopData paramBTShopData);
  
  void updateBoosters();
  
  void refreshShop();
  
  void closeShop();
  
  QuantityBoosterManager getQuantityBoosters();
  
  ChanceBoosterManager getChanceBoosterManager();
}
