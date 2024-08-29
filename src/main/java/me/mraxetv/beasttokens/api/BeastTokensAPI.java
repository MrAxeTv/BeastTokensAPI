package me.mraxetv.beasttokens.api;

import me.mraxetv.beasttokens.api.handlers.BTPlayersManager;
import me.mraxetv.beasttokens.api.handlers.BTShopManager;
import me.mraxetv.beasttokens.api.handlers.BTTokensManager;

public final class BeastTokensAPI
{
    private static BeastTokens instance;

    public static BTPlayersManager getPlayersManger() {
        return instance.getPlayersManager();
    }

    public static BTShopManager getShopManger() {
        return instance.getShopManager();
    }

    public static BTTokensManager getTokensManager() {return instance.getTokensManager();}
}
