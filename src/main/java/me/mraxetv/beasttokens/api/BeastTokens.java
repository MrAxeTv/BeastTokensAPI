package me.mraxetv.beasttokens.api;

import me.mraxetv.beasttokens.api.handlers.BTPlayersManager;
import me.mraxetv.beasttokens.api.handlers.BTShopManager;
import me.mraxetv.beasttokens.api.handlers.BTTokensManager;
import me.mraxetv.beasttokens.api.handlers.BTTradingCurrency;
import java.util.Collections;
import java.util.Map;

public interface BeastTokens {
    //TODO: Implement
    BTPlayersManager getPlayersManager();

    BTShopManager getShopManager();

    BTTokensManager getTokensManager();

    BTTokensManager getTokensManager(String currencyId);

    /** Strict, non-fallback discovery. Older implementations expose no capability. */
    default Map<String, BTTradingCurrency> getTradingCurrencies() {
        return Collections.emptyMap();
    }
}
