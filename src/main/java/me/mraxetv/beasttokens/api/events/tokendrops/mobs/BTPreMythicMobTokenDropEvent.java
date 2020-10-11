package me.mraxetv.beasttokens.api.events.tokendrops.mobs;

import io.lumine.xikage.mythicmobs.mobs.ActiveMob;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class BTPreMythicMobTokenDropEvent extends Event implements Cancellable {
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


    private ActiveMob mobType;
    private boolean perWorld;


    public boolean isPerWorld() {
        return perWorld;
    }

    public BTPreMythicMobTokenDropEvent(Player p, double chance, double multiplierChance, double percentageChance, ActiveMob mobType, boolean perWorld){
        this.player= p;
        this.chance = chance;
        this.multiplierChance = multiplierChance;
        this.percentageChance = percentageChance;
        this.mobType = mobType;
        this.perWorld = perWorld;
    }
    public Player getPlayer() {
        return player;
    }



    public ActiveMob getMobType() {
        return mobType;
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
