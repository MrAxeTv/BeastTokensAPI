package me.mraxetv.beasttokens.api;

import me.mraxetv.beasttokens.api.handlers.BTPlayersManager;
import me.mraxetv.beasttokens.api.handlers.BTShopManager;
import me.mraxetv.beasttokens.api.handlers.BTTokensManager;

public interface BeastTokens {
    //TODO: Implement
    BTPlayersManager getPlayersManager();

    BTShopManager getShopManager();

    BTTokensManager getTokensManager();
}
