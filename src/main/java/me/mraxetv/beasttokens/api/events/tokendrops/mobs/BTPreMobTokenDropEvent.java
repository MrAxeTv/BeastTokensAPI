package me.mraxetv.beasttokens.api.events.tokendrops.mobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTPreMobTokenDropEvent
  extends Event implements Cancellable {
  private static final HandlerList HANDLERS = new HandlerList();
  private boolean cancelled;
  private Player player;
  private double chance;
  private double multiplierChance;
  private double percentageChance;
  private Entity mobType;
  private boolean perWorld;
  
  public void setChance(double chance) {
    this.chance = chance;
  } public double getChance() {
    return this.chance;
  }
  public double getTotalChance() {
    return this.chance + this.multiplierChance + this.percentageChance;
  }
  
  public double getMultiplierChance() {
    return this.multiplierChance;
  }
  
  public void setMultiplierChance(double multiplierChance) {
    this.multiplierChance = multiplierChance;
  }


  
  public double getPercentageChance() {
    return this.percentageChance;
  }
  
  public void setPercentageChance(double percentageChance) {
    this.percentageChance = percentageChance;
  }







  
  public boolean isPerWorld() {
    return this.perWorld;
  }
  
  public BTPreMobTokenDropEvent(Player p, double chance, double multiplierChance, double percentageChance, Entity mobType, boolean perWorld) {
    this.player = p;
    this.chance = chance;
    this.multiplierChance = multiplierChance;
    this.percentageChance = percentageChance;
    this.mobType = mobType;
    this.perWorld = perWorld;
  }
  public Player getPlayer() {
    return this.player;
  }


  
  public Entity getMobType() {
    return this.mobType;
  }


  
  public boolean isCancelled() {
    return this.cancelled;
  }

  
  public void setCancelled(boolean b) {
    this.cancelled = b;
  }
  
  public HandlerList getHandlers() {
    return HANDLERS;
  }
  
  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
