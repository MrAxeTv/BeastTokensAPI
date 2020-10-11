package me.mraxetv.beasttokens.api.events.tokendrops.farming;


import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BTPreFarmingTokenDropEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancelled;



    private Player player;

    private double chance;

    public void setChance(double chance) {
        this.chance = chance;
    }
    public double getChance(){return chance;}

    public double getTotalChance(){
        return chance + multiplierChance + percentageChance;
    }

    public double getMultiplierChance() {
        return multiplierChance;
    }

    public void setMultiplierChance(double multiplierChance) {
        this.multiplierChance = multiplierChance;
    }

    private double multiplierChance;

    public double getPercentageChance() {
        return percentageChance;
    }

    public void setPercentageChance(double percentageChance) {
        this.percentageChance = percentageChance;
    }

    private double percentageChance;


    private Block block;
    private boolean perWorld;


    public boolean isPerWorld() {
        return perWorld;
    }

    public BTPreFarmingTokenDropEvent(Player p, double chance, double multiplierChance, double percentageChance, Block block, boolean perWorld){
        this.player= p;
        this.chance = chance;
        this.multiplierChance = multiplierChance;
        this.percentageChance = percentageChance;
        this.block = block;
        this.perWorld = perWorld;
    }
    public Player getPlayer() {
        return player;
    }



    public Block getBlock() {
        return block;
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
