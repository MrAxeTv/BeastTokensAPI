package me.mraxetv.beasttokens.api.events.tokendrops.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BTMobTokenDropEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;



    private Player player;

    public void setTokens(double tokens) {
        this.tokens = tokens;
    }

    public double getTotalTokens() {
        return tokens+ getMultiplierTokens() + getPercentageTokens();
    }


    private double tokens;
    private Entity mobType;


    private double multiplierTokens;

    public void setMultiplierTokens(double multiplierTokens) {
        this.multiplierTokens = multiplierTokens;
    }

    public double getMultiplierTokens() {
        return multiplierTokens;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setPercentageTokens(double percentageTokens) {
        this.percentageTokens = percentageTokens;
    }

    private double percentageTokens;

    public double getPercentageTokens() {
        return percentageTokens;
    }


    public Player getPlayer() {
        return player;
    }


    public Entity getMobType() {
        return mobType;
    }

    public double getTokens() {
        return tokens;
    }


    public BTMobTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Entity mobType){
        this.player= p;
        this.multiplierTokens = multiplierTokens;
        this.percentageTokens = percentageTokens;
        this.tokens = tokens;
        this.mobType = mobType;
    }


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

}
