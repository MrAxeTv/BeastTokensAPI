package me.mraxetv.beasttokens.api.wrappers.shop;

import org.bukkit.configuration.file.FileConfiguration;

public interface BTShopData {
  String getName();
  
  String getTitle();
  
  BTItemData getItemData(String paramString);
  
  boolean hasItemData(int paramInt);
  
  FileConfiguration getConfig();
  
  void saveConfig();
  
  BTShopRotatingData getRotatingData();

  int getPagesSize();

}
