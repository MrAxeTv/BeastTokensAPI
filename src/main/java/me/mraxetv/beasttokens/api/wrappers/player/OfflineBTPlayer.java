package me.mraxetv.beasttokens.api.wrappers.player;

import me.mraxetv.beasttokens.api.wrappers.boosters.ChanceBoosterManager;
import me.mraxetv.beasttokens.api.wrappers.boosters.QuantityBoosterManager;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public interface OfflineBTPlayer {


    OfflinePlayer getOfflinePlayer();

    String getName();

    UUID getUUID();

    QuantityBoosterManager getQuantityBoosters();

    ChanceBoosterManager getChanceBoosterManager();
}
