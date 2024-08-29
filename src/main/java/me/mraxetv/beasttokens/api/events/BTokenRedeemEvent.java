package me.mraxetv.beasttokens.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class BTokenRedeemEvent
  extends Event implements Cancellable {
  private final Player p;
  private boolean isCancelled;
  private final ItemStack item;
  private final boolean offHand;
  private double tokens;
  
  public BTokenRedeemEvent(Player p, ItemStack item, double tokens, boolean offHand) {
    this.p = p;
    this.item = item;
    this.offHand = offHand;
    this.tokens = tokens;
  }
  public Player getPlayer() {
    return this.p;
  } public ItemStack getItem() {
    return this.item;
  } public double getTokens() {
    return this.tokens;
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
