package me.mraxetv.beasttokens.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class BTokenRedeemEvent
  extends Event implements Cancellable, BTCurrencyEvent {
  private final Player p;
  private boolean isCancelled;
  private final ItemStack item;
  private final boolean offHand;
  private double tokens;
  private final String currencyId;
  private final BTTransactionReason transactionReason;
  
  public BTokenRedeemEvent(Player p, ItemStack item, double tokens, boolean offHand) {
    this(p, item, tokens, offHand, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
  }

  public BTokenRedeemEvent(Player p, ItemStack item, double tokens, boolean offHand, String currencyId) {
    this(p, item, tokens, offHand, currencyId, BTTransactionReason.REDEEM);
  }

  public BTokenRedeemEvent(Player p, ItemStack item, double tokens, boolean offHand, String currencyId, BTTransactionReason transactionReason) {
    this.p = p;
    this.item = item;
    this.offHand = offHand;
    this.tokens = tokens;
    this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
    this.transactionReason = transactionReason == null ? BTTransactionReason.REDEEM : transactionReason;
  }
  public Player getPlayer() {
    return this.p;
  } public ItemStack getItem() {
    return this.item;
  } public double getTokens() {
    return this.tokens;
  } public String getCurrencyId() {
    return this.currencyId;
  } public BTTransactionReason getTransactionReason() {
    return this.transactionReason;
  } public boolean inOffHand() {
    return this.offHand;
  } public boolean isCancelled() {
    return this.isCancelled;
  } public void setCancelled(boolean isCancelled) {
    this.isCancelled = isCancelled;
  }
  private static final HandlerList HANDLERS = new HandlerList();
  public HandlerList getHandlers() {
    return HANDLERS;
  } public static HandlerList getHandlerList() {
    return HANDLERS;
  }
}
