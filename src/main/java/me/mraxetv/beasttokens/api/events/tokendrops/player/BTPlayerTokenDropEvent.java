package me.mraxetv.beasttokens.api.events.tokendrops.player;

import lombok.Setter;
import me.mraxetv.beasttokens.api.events.BTCurrencyEvent;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTPlayerTokenDropEvent
  extends Event implements Cancellable, BTCurrencyEvent {
  private static final HandlerList HANDLERS = new HandlerList();
  private boolean cancelled;
  @Setter
  private Player player;
  @Setter
  private double tokens;
  private Player target;
  private final String currencyId;

  public Player getPlayer() {
    return this.player;
  }
  public Player getTarget() {
    return this.target;
  }
  public double getTokens() {
    return this.tokens;
  }
  public String getCurrencyId() {
    return this.currencyId;
  }
  public BTTransactionReason getTransactionReason() {
    return BTTransactionReason.DROP;
  }
  public BTPlayerTokenDropEvent(Player p, double tokens,Player target) {
    this(p, tokens, target, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTPlayerTokenDropEvent(Player p, double tokens,Player target, String currencyId) {
    this.player = p;
    this.tokens = tokens;
    this.target = target;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
  }
  public boolean isCancelled() {
    return this.cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }

  public HandlerList getHandlers() {
    return HANDLERS;
  }
  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
