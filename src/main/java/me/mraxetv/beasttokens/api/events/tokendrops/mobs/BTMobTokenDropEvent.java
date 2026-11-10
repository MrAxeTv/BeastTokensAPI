package me.mraxetv.beasttokens.api.events.tokendrops.mobs;

import lombok.Getter;
import lombok.Setter;
import me.mraxetv.beasttokens.api.events.BTCurrencyEvent;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class BTMobTokenDropEvent
  extends Event implements Cancellable, BTCurrencyEvent {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;
  
  @Setter
  private Player player;
  @Setter
  private double tokens;

    private Entity mobType; @Setter
    private double multiplierTokens; private double percentageTokens;
    private final String currencyId;


    public void setPercentageTokens(double percentageTokens) {
    this.percentageTokens = percentageTokens;
  }


    public BTMobTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Entity mobType) {
    this(p, tokens, multiplierTokens, percentageTokens, mobType, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTMobTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Entity mobType, String currencyId) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.mobType = mobType;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
  }


    public HandlerList getHandlers() {
    return HANDLERS;
  }

  public BTTransactionReason getTransactionReason() {
    return BTTransactionReason.DROP;
  }

  @Override
  public boolean isCancelled() {
    return this.cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
  
  public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
