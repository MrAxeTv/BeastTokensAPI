package me.mraxetv.beasttokens.api.handlers;

import java.util.ArrayList;
import java.util.Set;
import me.mraxetv.beasttokens.api.wrappers.shop.BTShopData;

public interface BTShopManager {
  boolean isShopExists(String paramString);
  
  Set<String> getShopsIds();
  
  ArrayList<String> getShopsList();
  
  BTShopData getShop(String paramString);
}
