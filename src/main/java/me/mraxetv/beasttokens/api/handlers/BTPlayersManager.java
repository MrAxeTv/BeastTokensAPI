package me.mraxetv.beasttokens.api.handlers;

import java.util.Collection;
import java.util.UUID;
import me.mraxetv.beasttokens.api.wrappers.player.BTOfflinePlayer;
import me.mraxetv.beasttokens.api.wrappers.player.BTPlayer;
import org.bukkit.entity.Player;

public interface BTPlayersManager {
  BTPlayer getBTPlayer(String paramString);
  
  BTPlayer getBTPlayer(UUID paramUUID);
  
  BTPlayer getBTPlayer(Player paramPlayer);
  
  BTOfflinePlayer getBTOfflinePlayer(UUID paramUUID);
  
  void updateAllBoosters();
  
  Collection<? extends BTPlayer> getBTPlayers();
}
