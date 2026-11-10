package me.mraxetv.beasttokens.api;

/**
 * @deprecated Use {@link me.mraxetv.beasttokens.api.events.BTTransactionReason},
 * which distinguishes the exact transaction operation.
 */
@Deprecated
public enum TokensUpdateReason
{
  API,
  ADMIN,
  DROP,
  SHOP,
  PAY;
}
