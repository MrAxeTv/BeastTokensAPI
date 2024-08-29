package me.mraxetv.beasttokens.api.events.tokendrops.farming;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTFarmingTokenDropEvent
  extends Event implements Cancellable {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;

  private double customMultiplier;
  
  private Player player;
  private double tokens;
  
  public void setTokens(double tokens) {
    this.tokens = tokens;
  }
  private Block block; private double multiplierTokens; private double percentageTokens;
  public double getTotalTokens() {
    return this.tokens + getMultiplierTokens() + getPercentageTokens();
  }


  public void setMultiplierTokens(double multiplierTokens) {
    this.multiplierTokens = multiplierTokens;
  }
  
  public double getMultiplierTokens() {
    return this.multiplierTokens;
  }
  
  public void setPlayer(Player player) {
    this.player = player;
  }
  
  public void setPercentageTokens(double percentageTokens) {
    this.percentageTokens = percentageTokens;
  }


  
  public double getPercentageTokens() {
    return this.percentageTokens;
  }

  
  public Player getPlayer() {
    return this.player;
  }

  
  public Block getBlock() {
    return this.block;
  }
  
  public double getTokens() {
    return this.tokens;
  }

  
  public BTFarmingTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Block block, double custom) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.block = block;
    this.customMultiplier = custom;
  }


  
  public boolean isCancelled() {
    return this.cancelled;
  }

  public boolean hasCustomMultiplier(){
    return customMultiplier > 0;
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
