package me.mraxetv.beasttokens;


import me.mraxetv.beasttokens.api.handlers.PlayersManager;
import me.mraxetv.beasttokens.api.handlers.ShopManager;
import me.mraxetv.beasttokens.api.handlers.TokensManager;

public interface BeastTokens {


   PlayersManager getPlayersManager();
   ShopManager getShopManager();
   TokensManager getTokensManager();


}
