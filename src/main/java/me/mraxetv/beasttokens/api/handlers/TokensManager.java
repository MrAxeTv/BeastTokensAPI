package me.mraxetv.beasttokens.api.handlers;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public interface TokensManager {

// Check if player tokens are loaded in memory
    boolean isLoaded(OfflinePlayer p);

    //Tokens are automatically saved when player leaves
    //If player is offline tokens are set in data base
    void saveTokens(Player p, boolean unload);


    //Will return max tokens set in config!
    double getMaxTokens();

    //Will return true/false if player balance if full
    boolean hasMaxTokens(Player p);

    //Set tokens to player
    void setTokens(Player p, double amount);

    //Set tokens to offline player should be used async
    void setTokens(OfflinePlayer p, double amount);

    //Add tokens to player
    void addTokens(Player p, double amount);

    //Add tokens to offline player should be used async
    void addTokens(OfflinePlayer p, double amount);

    //Remove tokens from player balance
    void removeTokens(Player p, double amount);

    //Remove tokens from offline player should be used async
    void removeTokens(OfflinePlayer p, double amount);

    //Get tokens from player balance
    double getTokens(Player p);

    //Get tokens from player balance should be used async
    double getTokens(OfflinePlayer p);


    ArrayList<String> getTopList();

    void loadPlayer(Player p);

    ItemStack getTokenNote(String signerName, double tokens, int amount, boolean signet);


    void saveAll();
}
