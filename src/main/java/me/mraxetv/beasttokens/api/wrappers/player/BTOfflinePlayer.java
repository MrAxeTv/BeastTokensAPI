package me.mraxetv.beasttokens.api.wrappers.player;

import java.util.UUID;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;

public interface BTOfflinePlayer {
  OfflinePlayer getOfflinePlayer();
  
  String getName();
  
  UUID getUUID();
  
  FileConfiguration getConfig();
  
  void saveFile();
}
