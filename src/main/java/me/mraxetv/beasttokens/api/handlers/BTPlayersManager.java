package me.mraxetv.beasttokens.api.handlers;


import me.mraxetv.beasttokens.api.wrappers.player.BTOfflinePlayer;
import me.mraxetv.beasttokens.api.wrappers.player.BTPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public interface BTPlayersManager {

   BTPlayer getBTPlayer(String name);
   BTPlayer getBTPlayer(UUID uuid);

BTPlayer getBTPlayer(Player p) ;

   BTOfflinePlayer getBTOfflinePlayer(UUID uuid);

   void updateAllBoosters();




   Collection<? extends BTPlayer> getBTPlayers();



}
