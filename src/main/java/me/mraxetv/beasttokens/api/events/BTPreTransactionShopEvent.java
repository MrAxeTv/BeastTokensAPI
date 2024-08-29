package me.mraxetv.beasttokens.api.events;

import me.mraxetv.beasttokens.api.wrappers.shop.BTItemData;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BTPreTransactionShopEvent
  extends Event
  implements Cancellable
{
  private static final HandlerList HANDLERS = new HandlerList();
  
  private boolean cancelled;
  
  private BTItemData itemInfo;
  
  private String shopName;
  
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
  
  public BTPreTransactionShopEvent(Player p, String shopName, BTItemData item) {
    this.player = p;
    this.itemInfo = item;
    this.shopName = shopName;
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
