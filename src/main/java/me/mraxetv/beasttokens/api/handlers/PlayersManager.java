package me.mraxetv.beasttokens.api.handlers;


import me.mraxetv.beasttokens.api.wrappers.player.BTPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

public interface PlayersManager {

   BTPlayer getBTPlayer(String name);
   BTPlayer getBTPlayer(UUID uuid);
   BTPlayer getBTPlayer(Player p);

   Collection<? extends BTPlayer> getBTPlayers();



}
