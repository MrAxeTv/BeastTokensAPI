package me.mraxetv.beasttokens.api.events.tokendrops.blocks;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BTBlockTokenDropEvent extends Event implements Cancellable {
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
    private Block block;


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


    public Block getBlock() {
        return block;
    }

    public double getTokens() {
        return tokens;
    }


    public BTBlockTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Block block){
        this.player= p;
        this.multiplierTokens = multiplierTokens;
        this.percentageTokens = percentageTokens;
        this.tokens = tokens;
        this.block = block;
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
