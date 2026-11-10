package me.mraxetv.beasttokens.api;

import me.mraxetv.beasttokens.api.handlers.BTPlayersManager;
import me.mraxetv.beasttokens.api.handlers.BTShopManager;
import me.mraxetv.beasttokens.api.handlers.BTTokensManager;
import me.mraxetv.beasttokens.api.handlers.BTTradingCurrency;
import java.util.Map;

public final class BeastTokensAPI
{
    private static BeastTokens instance;

    private BeastTokensAPI() {
    }

    public static boolean isAvailable() {
        return instance != null;
    }

    public static BeastTokens getInstance() {
        return requireInstance();
    }

    public static void setInstance(BeastTokens beastTokens) {
        if (beastTokens == null) throw new IllegalArgumentException("beastTokens cannot be null");
        instance = beastTokens;
    }

    public static void clearInstance(BeastTokens beastTokens) {
        if (instance == beastTokens) instance = null;
    }

    public static BTPlayersManager getPlayersManager() {
        return requireInstance().getPlayersManager();
    }

    public static BTShopManager getShopManager() {
        return requireInstance().getShopManager();
    }

    /**
     * @deprecated Use {@link #getPlayersManager()}.
     */
    @Deprecated
    public static BTPlayersManager getPlayersManger() {
        return getPlayersManager();
    }

    /**
     * @deprecated Use {@link #getShopManager()}.
     */
    @Deprecated
    public static BTShopManager getShopManger() {
        return getShopManager();
    }

    public static BTTokensManager getTokensManager() {
        return requireInstance().getTokensManager();
    }

    public static BTTokensManager getTokensManager(String currencyId) {
        return requireInstance().getTokensManager(currencyId);
    }

    /** Exact configured IDs; unknown IDs are absent and never use a default wallet. */
    public static Map<String, BTTradingCurrency> getTradingCurrencies() {
        return requireInstance().getTradingCurrencies();
    }

    private static BeastTokens requireInstance() {
        if (instance == null) {
            throw new IllegalStateException("BeastTokens API is not available. Check that BeastTokens is enabled.");
        }
        return instance;
    }
}
