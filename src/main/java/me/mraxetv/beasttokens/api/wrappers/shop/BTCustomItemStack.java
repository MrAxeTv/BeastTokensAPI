package me.mraxetv.beasttokens.api.wrappers.shop;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface BTCustomItemStack extends Cloneable {

  void setType(String paramString);
  
  void setAmount(int paramInt);
  
  void setDisplayName(String paramString);
  
  void setDisplayLore(List<String> paramList);
  
  void setDurability(int paramInt);
  
  void setCustomModelData();
  
  void setCustomModelData(int paramInt);

  
  void setGlow(boolean paramBoolean);
  
  ItemStack clone();

  String getDisplayName();
}
