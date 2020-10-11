package me.mraxetv.beasttokens.api.wrappers.player;

import me.mraxetv.beasttokens.api.wrappers.boosters.ChanceBoosterManager;
import me.mraxetv.beasttokens.api.wrappers.boosters.QuantityBoosterManager;
import me.mraxetv.beasttokens.api.wrappers.shop.ShopData;
import org.bukkit.entity.Player;

public interface BTPlayer {
    Player getPlayer();

    String getName();

    boolean hasOpenShop();

    //void setShop(String shop);

    ShopData getShop();
    String getShopName();

    void openShop(String shop);
    void openShop(ShopData shop);

    void closeShop();

    //void removeShop();

    QuantityBoosterManager getQuantityBoosters();

    ChanceBoosterManager getChanceBoosterManager();
}
