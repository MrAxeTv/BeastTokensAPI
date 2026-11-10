package me.mraxetv.beasttokens.api.events;

public interface BTCurrencyEvent {
  String DEFAULT_CURRENCY_ID = "Tokens";

  String getCurrencyId();

  default BTTransactionReason getTransactionReason() {
    return BTTransactionReason.UNKNOWN;
  }

  static String normalizeCurrencyId(String currencyId) {
    if (currencyId == null || currencyId.trim().isEmpty()) return DEFAULT_CURRENCY_ID;
    return currencyId.trim();
  }
}
