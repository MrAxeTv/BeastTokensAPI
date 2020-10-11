package me.mraxetv.beasttokens.api.wrappers.shop;

import org.bukkit.configuration.file.FileConfiguration;

public interface ShopData {

    String getName();

    String getTitle();

    ItemData getItemData(int slot);

    FileConfiguration getConfig();

    void saveConfig();



}
