package me.mraxetv.beasttokens.api.events;

import me.mraxetv.beasttokens.api.wrappers.shop.ItemData;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BTPostTransactionShopEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;


    private ItemData itemInfo;

    private String shopName;

    private Player player;

    public ItemData getItemInfo() {
        return itemInfo;
    }

    public Player getPlayer() {
        return player;
    }

    public String getShopName() {
        return shopName;
    }

    public BTPostTransactionShopEvent(Player p , String shopName, ItemData item){
        this.player= p;
        this.itemInfo = item;
        this.shopName = shopName;
    }


    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
