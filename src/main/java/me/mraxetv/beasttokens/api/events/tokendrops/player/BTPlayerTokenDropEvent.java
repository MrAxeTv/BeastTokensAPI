package me.mraxetv.beasttokens.api.events.tokendrops.player;

import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTPlayerTokenDropEvent
  extends Event implements Cancellable {
  private static final HandlerList HANDLERS = new HandlerList();
  @Setter
  private boolean cancelled;
  @Setter
  private Player player;
  @Setter
  private double tokens;
  private Player target;

  public Player getPlayer() {
    return this.player;
  }
  public Player getTarget() {
    return this.target;
  }
  public double getTokens() {
    return this.tokens;
  }
  public BTPlayerTokenDropEvent(Player p, double tokens,Player target) {
    this.player = p;
    this.tokens = tokens;
    this.target = target;
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
