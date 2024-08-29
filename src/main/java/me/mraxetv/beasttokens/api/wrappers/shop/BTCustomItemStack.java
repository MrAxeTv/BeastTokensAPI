package me.mraxetv.beasttokens.api.wrappers.shop;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface BTCustomItemStack extends Cloneable {
  boolean isItem(Material paramMaterial);
  
  void setType(String paramString);
  
  void setAmount(int paramInt);
  
  void setDisplayName(String paramString);
  
  void setLore(List<String> paramList);
  
  void setDurability(int paramInt);
  
  void setCustomModelData();
  
  void setCustomModelData(int paramInt);

  
  void setGlow(boolean paramBoolean);
  
  ItemStack clone();

  String getDisplayName();
}
