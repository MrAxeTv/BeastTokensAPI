package me.mraxetv.beasttokens.api.events.tokendrops.blocks;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTMiningDropEvent
  extends Event implements Cancellable {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;
  
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

  
  public BTMiningDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Block block) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.block = block;
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
