package me.mraxetv.beasttokens.api.wrappers.shop;

import me.mraxetv.beasttokens.api.StockType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import java.util.List;

public interface BTItemData {
  String getPermission();
  
  void setPermission(String paramString);
  
  boolean hasPermission(Player p);

  String getDeclinedPermission();

  void setDeclinedPermission(String permission);
  boolean hasDeclinedPermission(Player p);


  List<Integer> getSlots();

  String getId();
  
  String getShopName();



  boolean isCloseAfterTransaction();
  
  void setCloseAfterTransaction(boolean paramBoolean);
  
  BTCustomItemStack getGUIStack();

  
  boolean isUpdatable();
  
  ConfigurationSection getConfig();

  default String getCurrencyId() {
    return null;
  }

  default String getBuyCurrencyId() {
    return getCurrencyId();
  }

  default String getSellCurrencyId() {
    return getCurrencyId();
  }

  default StockType getBuyStockType() {
    return null;
  }

  default StockType getSellStockType() {
    return null;
  }
}
