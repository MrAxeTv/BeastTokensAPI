package me.mraxetv.beasttokens.api.events.tokendrops.fishing;

import lombok.Getter;
import lombok.Setter;
import me.mraxetv.beasttokens.api.events.BTCurrencyEvent;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTFishingTokenDropEvent
  extends Event implements Cancellable, BTCurrencyEvent {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;
  
  @Getter
  @Setter
  private Player player;
  @Getter
  @Setter
  private double tokens;

    private Material material; @Getter
    @Setter
    private double multiplierTokens;
    @Getter
    @Setter
    private double percentageTokens;
    @Getter
    private final String currencyId;

    public Material getType() {
    return this.material;
  }

    public BTFishingTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Material material) {
    this(p, tokens, multiplierTokens, percentageTokens, material, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTFishingTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Material material, String currencyId) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.material = material;
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
