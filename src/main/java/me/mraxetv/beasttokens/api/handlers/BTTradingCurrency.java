package me.mraxetv.beasttokens.api.handlers;

import org.bukkit.entity.Player;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Optional checked online-wallet capability. Calls belong on the ordinary server
 * thread. Results confirm the current cache only, not disk persistence or a
 * distributed transaction. Operation IDs are correlation IDs, not durable replay
 * protection; an unknown outcome must never be retried blindly.
 */
public interface BTTradingCurrency {
    String currencyId();
    String displayName();
    String symbol();
    String format();
    BigDecimal maximumBalance();
    /** 0 for whole amounts, -1 when storage has no fixed decimal scale. */
    int decimalPlaces();
    String walletIdentity();
    boolean isAvailable();
    boolean isReady(Player player);
    /** Throws when the online cache is unavailable; zero is a genuine balance. */
    BigDecimal balance(Player player);
    BTBalanceChangeResult withdraw(Player player, BigDecimal amount, UUID operationId);
    BTBalanceChangeResult deposit(Player player, BigDecimal amount, UUID operationId);
}
