package me.mraxetv.beasttokens.api.events.tokendrops.farming;

import lombok.Getter;
import lombok.Setter;
import me.mraxetv.beasttokens.api.events.BTCurrencyEvent;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTFarmingTokenDropEvent
  extends Event implements Cancellable, BTCurrencyEvent {
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;

  private double customMultiplier;
  
  @Getter
  @Setter
  private Player player;
  @Getter
  @Setter
  private double tokens;

    @Getter
    private Block block; @Getter
    @Setter
    private double multiplierTokens; @Getter
    @Setter
    private double percentageTokens;
    @Getter
    private final String currencyId;


    public BTFarmingTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Block block, double custom) {
    this(p, tokens, multiplierTokens, percentageTokens, block, custom, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTFarmingTokenDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, Block block, double custom, String currencyId) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.block = block;
    this.customMultiplier = custom;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
  }


  
  public boolean isCancelled() {
    return this.cancelled;
  }

  public BTTransactionReason getTransactionReason() {
    return BTTransactionReason.DROP;
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
