package me.mraxetv.beasttokens.api.wrappers.shop;

import java.util.Collection;

public interface BTShopPage {
  void addItem(BTItemData paramBTItemData);
  
  boolean hasItem(int paramInt);
  
  boolean hasItem(String paramString);
  
  void removeItem(String paramString);
  
  Collection<String> getItemDataList();
  
  BTItemData getItemData(int paramInt);
}
