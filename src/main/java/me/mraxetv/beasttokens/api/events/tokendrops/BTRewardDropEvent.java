package me.mraxetv.beasttokens.api.events.tokendrops;

import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTRewardDropEvent
  extends Event implements Cancellable {
  private static final HandlerList HANDLERS = new HandlerList();
  @Setter
  private boolean cancelled;
  @Setter
  private Player player;
  @Setter
  private double tokens;
  private final String type;
  @Setter
  private double multiplierTokens;
  @Setter
  private double percentageTokens;
  public double getTotalTokens() {
    return this.tokens + getMultiplierTokens() + getPercentageTokens();
  }
  public double getMultiplierTokens() {
    return this.multiplierTokens;
  }
    public double getPercentageTokens() {
    return this.percentageTokens;
  }


  public Player getPlayer() {
    return this.player;
  }
  public String getType() {
    return this.type;
  }
  public double getTokens() {
    return this.tokens;
  }


  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens,String type) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.type = type;
  }

  public boolean isCancelled() {
    return this.cancelled;
  }
  public HandlerList getHandlers() {
    return HANDLERS;
  }
  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
