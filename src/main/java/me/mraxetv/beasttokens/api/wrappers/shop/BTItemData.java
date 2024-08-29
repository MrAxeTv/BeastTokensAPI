package me.mraxetv.beasttokens.api.wrappers.shop;

import java.util.List;

import me.mraxetv.beasttokens.api.StockType;
import org.bukkit.configuration.ConfigurationSection;

public interface BTItemData {
  String getPermission();
  
  void setPermission(String paramString);
  
  boolean hasPermission();

  String getDeclinedPermission();

  void setDeclinedPermission(String permission);
  boolean hasDeclinedPermission();

  
  void setPrice(double paramDouble);
  
  void setCmd(List<String> paramList);
  
  void setRandomCmd(List<String> paramList);
  
  void setPlayerCmd(List<String> paramList);
  
  int getSlot();

  List<Integer> getSlots();

  String getId();
  
  String getShopName();
  
  List<String> getCmd();
  
  List<String> getRandomCmd();
  
  List<String> getPlayerCmd();
  
  boolean hasCmd();
  
  boolean hasRandomCmd();
  
  boolean hasPlayerCmd();
  
  boolean hasOpenShop();
  
  String getOpenShop();
  
  void setOpenShop(String paramString);
  
  boolean isStockLimited();
  
  StockType getStockType();
  
  int getMaxStockAmount();
  
  int getSoldStockAmount();
  
  void setSoldStockAmount(int paramInt);
  
  double getPrice();
  
  boolean isCloseShop();
  
  void setCloseShop(boolean paramBoolean);
  
  boolean isFree();
  
  BTCustomItemStack getCustomItemStack();
  
  boolean isSkull();
  
  String getSkullName();
  
  boolean isUpdatable();
  
  ConfigurationSection getConfig();
}
