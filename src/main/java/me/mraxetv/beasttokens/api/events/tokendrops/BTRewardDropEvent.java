package me.mraxetv.beasttokens.api.events.tokendrops;

import lombok.Getter;
import lombok.Setter;
import me.mraxetv.beasttokens.api.DropType;
import me.mraxetv.beasttokens.api.events.BTCurrencyEvent;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class BTRewardDropEvent<T>
  extends Event implements Cancellable, BTCurrencyEvent {
  private static final HandlerList HANDLERS = new HandlerList();

  T object;
  private boolean cancelled;
  @Setter
  private Player player;
  @Setter
  private double tokens;
  private final DropType dropType;
  private final String currencyId;
  private final BTTransactionReason transactionReason;
  @Setter
  private double multiplierTokens;
  @Setter
  private double percentageTokens;


    public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens,String dropType) {
    this(p, tokens, multiplierTokens, percentageTokens, dropType, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens,String dropType, String currencyId) {
    this(p, tokens, multiplierTokens, percentageTokens, DropType.valueOf(dropType), null, currencyId);
  }
  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, DropType dropType) {
    this(p, tokens, multiplierTokens, percentageTokens, dropType, null, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }
  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, DropType dropType, String currencyId) {
    this(p, tokens, multiplierTokens, percentageTokens, dropType, null, currencyId);
  }
  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, DropType dropType,T object) {
    this(p, tokens, multiplierTokens, percentageTokens, dropType, object, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }
  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, DropType dropType,T object, String currencyId) {
    this(p, tokens, multiplierTokens, percentageTokens, dropType, object, currencyId, BTTransactionReason.DROP);
  }
  public BTRewardDropEvent(Player p, double tokens, double multiplierTokens, double percentageTokens, DropType dropType,T object, String currencyId, BTTransactionReason transactionReason) {
    this.player = p;
    this.multiplierTokens = multiplierTokens;
    this.percentageTokens = percentageTokens;
    this.tokens = tokens;
    this.dropType = dropType;
    this.object = object;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
    this.transactionReason = transactionReason == null ? BTTransactionReason.DROP : transactionReason;

  }


    public HandlerList getHandlers() {
    return HANDLERS;
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
