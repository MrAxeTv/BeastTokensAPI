package me.mraxetv.beasttokens.api.events;

import me.mraxetv.beasttokens.api.wrappers.shop.BTItemData;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTPreTransactionShopEvent
  extends Event
  implements Cancellable, BTCurrencyEvent
{
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;
  
  private BTItemData itemInfo;
  
  private String shopName;

  private final String currencyId;
  private final BTTransactionReason transactionReason;
  
  private Player player;
  
  public BTItemData getItemInfo() {
    return this.itemInfo;
  }
  
  public Player getPlayer() {
    return this.player;
  }
  
  public String getShopName() {
    return this.shopName;
  }

  public String getCurrencyId() {
    return this.currencyId;
  }

  public BTTransactionReason getTransactionReason() {
    return this.transactionReason;
  }
  
  public BTPreTransactionShopEvent(Player p, String shopName, BTItemData item) {
    this(p, shopName, item, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTPreTransactionShopEvent(Player p, String shopName, BTItemData item, String currencyId) {
    this(p, shopName, item, currencyId, BTTransactionReason.UNKNOWN);
  }

  public BTPreTransactionShopEvent(Player p, String shopName, BTItemData item, String currencyId, BTTransactionReason transactionReason) {
    this.player = p;
    this.itemInfo = item;
    this.shopName = shopName;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
    this.transactionReason = transactionReason == null ? BTTransactionReason.UNKNOWN : transactionReason;
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
