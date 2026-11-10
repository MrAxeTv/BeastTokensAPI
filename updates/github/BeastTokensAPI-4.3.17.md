# BeastTokens Developer API 4.3.17

[![Get BeastTokens on Spigot](https://raw.githubusercontent.com/MrAxeTv/BeastTokensAPI/ca2370c8358748ee503f7ec113be5cdbd6374492/.github/assets/get-beasttokens-spigot.svg)](https://www.spigotmc.org/resources/beasttokens-multishop-mob-and-block-token-drops.20806/) [![Get BeastTokens on BuiltByBit](https://raw.githubusercontent.com/MrAxeTv/BeastTokensAPI/ca2370c8358748ee503f7ec113be5cdbd6374492/.github/assets/get-beasttokens-builtbybit.svg)](https://builtbybit.com/resources/beasttokens.28772/)

Developer API for integrating with **BeastTokens 4.3.17**. The full BeastTokens plugin is required on the server. Download the API JAR from **Assets** below and use it as a `provided` / `compileOnly` dependency.

## API additions

- Currency-specific manager access, currency IDs and transaction reasons on events, and per-currency prices on shop buy/sell events.
- Checked native-wallet trading through `BTTradingCurrency`: exact currency discovery, online readiness, precision and balance limits, plus explicit `SUCCESS`, `REJECTED`, and `UNKNOWN` outcomes.
- Public API availability checks and instance access, with correctly spelled player and shop manager getters.

## Fixes and build

- Clear API-unavailable errors when BeastTokens has not enabled or has shut down.
- Standalone Maven build using the public Spigot API, with no private BeastTokens parent project required.
- API sources, Javadocs, and SHA-256 checksums included as release assets. Generated build and IDE files are excluded from the current repository tree.

## Documentation

- New [developer setup and examples](https://github.com/MrAxeTv/BeastTokensAPI/blob/4.3.17/README.md): Maven, Gradle, plugin dependencies, balances, and checked payments.
- Documented exact currency lookup, server-thread requirements, and reconciliation for uncertain payment results. Operation IDs do not provide durable idempotency.

## Compatibility

- Targets the API shipped with **BeastTokens 4.3.17**. The package remains `me.mraxetv.beasttokens.api`; Maven coordinates remain `me.mraxetv.beasttokens:btapi`.
- Upgrading from 3.x requires recompilation and a review of changed event and wrapper signatures. Current shop completion events are `BTTransactionBuyEvent` and `BTTransactionSellEvent`; the old `BTPostTransactionShopEvent` and `ActionType` are absent.
- The old misspelled manager getters remain as deprecated aliases.
- This JAR is for developers. Install the full BeastTokens plugin on your server and keep the API classes out of your integration's shaded JAR.

## Downloads

| Asset | Purpose |
| --- | --- |
| `BeastTokensAPI-4.3.17.jar` | Compile your integration against the public API |
| `BeastTokensAPI-4.3.17-sources.jar` | Browse API source in your IDE |
| `BeastTokensAPI-4.3.17-javadoc.jar` | Browse generated API reference documentation |
| `SHA256SUMS` | Verify the three JAR downloads |

GitHub's automatic **Source code** archives contain this public API repository. Purchase the full server plugin using either button above.
