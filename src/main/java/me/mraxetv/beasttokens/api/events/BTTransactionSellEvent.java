package me.mraxetv.beasttokens.api.events;

import lombok.Getter;
import me.mraxetv.beasttokens.api.wrappers.player.BTPlayer;
import me.mraxetv.beasttokens.api.wrappers.shop.BTItemData;
import me.mraxetv.beasttokens.api.wrappers.shop.BTShopData;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class BTTransactionSellEvent<P extends BTPlayer> extends Event implements BTCurrencyEvent {
    private static final HandlerList HANDLERS = new HandlerList();
    @Getter
    private boolean cancelled;
    @Getter
    private BTItemData itemData;
    @Getter
    private BTShopData shopData;
    @Getter
    private P btPlayer;
    @Getter
    private int sold = 1;
    @Getter
    private double totalPrice;
    @Getter
    private final String currencyId;
    @Getter
    private final Map<String, Double> totalPricesByCurrency;
    @Getter
    private final BTTransactionReason transactionReason;
    @Getter
    private final String transactionId;

    public BTTransactionSellEvent(P p, int sold, double totalPrice) {
        this(p, sold, totalPrice, BTCurrencyEvent.DEFAULT_CURRENCY_ID);
    }

    public BTTransactionSellEvent(P p, int sold, double totalPrice, String currencyId) {
        this(p, sold, totalPrice, currencyId, null);
    }

    public BTTransactionSellEvent(P p, int sold, double totalPrice, String currencyId, Map<String, Double> totalPricesByCurrency) {
        this(p, sold, totalPrice, currencyId, totalPricesByCurrency, BTTransactionReason.SHOP_SELL);
    }

    public BTTransactionSellEvent(P p, int sold, double totalPrice, String currencyId, Map<String, Double> totalPricesByCurrency, BTTransactionReason transactionReason) {
        this(p, sold, totalPrice, currencyId, totalPricesByCurrency, transactionReason, null);
    }

    public BTTransactionSellEvent(P p, int sold, double totalPrice, String currencyId,
                                  Map<String, Double> totalPricesByCurrency,
                                  BTTransactionReason transactionReason, String transactionId) {
        this.btPlayer = p;
        this.itemData = p.getShopView().getClickedItem();
        this.shopData = p.getShop();
        if(sold > 0) this.sold = sold;
        this.totalPrice = totalPrice;
        this.currencyId = BTCurrencyEvent.normalizeCurrencyId(currencyId);
        this.totalPricesByCurrency = normalizePrices(this.currencyId, totalPrice, totalPricesByCurrency);
        this.transactionReason = transactionReason == null ? BTTransactionReason.SHOP_SELL : transactionReason;
        this.transactionId = transactionId;
    }

    public double getTotalPrice(String currencyId) {
        if (currencyId == null) return 0.0;
        Double value = totalPricesByCurrency.get(BTCurrencyEvent.normalizeCurrencyId(currencyId));
        if (value != null) return value;
        for (Map.Entry<String, Double> entry : totalPricesByCurrency.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(currencyId.trim())) return entry.getValue();
        }
        return 0.0;
    }

    private Map<String, Double> normalizePrices(String currencyId, double totalPrice, Map<String, Double> configuredPrices) {
        LinkedHashMap<String, Double> prices = new LinkedHashMap<>();
        if (configuredPrices != null) {
            for (Map.Entry<String, Double> entry : configuredPrices.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) continue;
                prices.put(BTCurrencyEvent.normalizeCurrencyId(entry.getKey()), entry.getValue());
            }
        }
        if (prices.isEmpty() && totalPrice > 0) prices.put(currencyId, totalPrice);
        return Collections.unmodifiableMap(prices);
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
