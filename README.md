# BeastTokens Developer API

[![Get BeastTokens on Spigot](.github/assets/get-beasttokens-spigot.svg)](https://www.spigotmc.org/resources/beasttokens-multishop-mob-and-block-token-drops.20806/) [![Get BeastTokens on BuiltByBit](.github/assets/get-beasttokens-builtbybit.svg)](https://builtbybit.com/resources/beasttokens.28772/)

Build integrations for BeastTokens currencies, players, shops, boosters, and events. This repository contains the public Java API and its developer documentation. The BeastTokens server implementation is distributed through the stores above.

**[Download API 4.3.17](https://github.com/MrAxeTv/BeastTokensAPI/releases/tag/4.3.17)** — the compiled JAR, sources, Javadocs, and SHA-256 checksums are under **Assets**.

The full BeastTokens plugin is required on the server. Use the API JAR as a compile dependency; do not put it in the server's `plugins/` folder or shade its classes into your plugin. BeastTokens supplies these classes at runtime.

## Add the dependency

The Maven coordinates remain `me.mraxetv.beasttokens:btapi`. This release does not require access to the private BeastTokens project.

### Maven

Download `BeastTokensAPI-4.3.17.jar` from the release, then install it into your local Maven repository:

```shell
mvn install:install-file -Dfile=BeastTokensAPI-4.3.17.jar -DgroupId=me.mraxetv.beasttokens -DartifactId=btapi -Dversion=4.3.17 -Dpackaging=jar -DgeneratePom=true
```

Add this to your plugin's `pom.xml`, alongside your normal Bukkit, Spigot, or Paper API dependency:

```xml
<dependency>
    <groupId>me.mraxetv.beasttokens</groupId>
    <artifactId>btapi</artifactId>
    <version>4.3.17</version>
    <scope>provided</scope>
</dependency>
```

Alternatively, clone this repository and run `mvn clean install` to build and install the API locally. For CI builds, build this repository first or make the API artifact available through your own dependency repository.

### Gradle

Place the downloaded JAR in your project's `libs/` directory. In `build.gradle.kts`:

```kotlin
dependencies {
    compileOnly(files("libs/BeastTokensAPI-4.3.17.jar"))
}
```

Your project still needs its usual server API dependency. Integrations using the MythicMobs event types also need the matching MythicMobs API on their compile classpath; this repository builds against `io.lumine:Mythic-Dist:5.6.2` from [Lumine's repository](https://mvn.lumine.io/repository/maven-public/).

## Load after BeastTokens

For a plugin that requires BeastTokens, include this in `plugin.yml`:

```yaml
name: MyTokensIntegration
version: 1.0.0
main: example.MyTokensIntegration
depend: [BeastTokens]
```

If BeastTokens is optional, use `softdepend: [BeastTokens]` and load your BeastTokens integration classes only after checking that BeastTokens is installed and enabled. Keep API references inside that integration to avoid class loading errors when the dependency is absent.

## Get the API

These examples target BeastTokens **4.3.17**. Access the API after BeastTokens has enabled:

```java
package example;

import me.mraxetv.beasttokens.api.BeastTokens;
import me.mraxetv.beasttokens.api.BeastTokensAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyTokensIntegration extends JavaPlugin {
    @Override
    public void onEnable() {
        if (!BeastTokensAPI.isAvailable()) {
            getLogger().severe("BeastTokens is not ready.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        BeastTokens api = BeastTokensAPI.getInstance();
        getLogger().info("BeastTokens API connected.");
    }
}
```

`getInstance()` and manager getters throw `IllegalStateException` while the API is unavailable. Check availability again before using a cached integration after BeastTokens has been disabled or reloaded. The `setInstance` and `clearInstance` methods belong to the BeastTokens runtime lifecycle; integrations should not call them.

## Read or reward a balance

Run wallet operations on the server's main thread with loaded player data:

```java
import me.mraxetv.beasttokens.api.BeastTokensAPI;
import me.mraxetv.beasttokens.api.events.BTTransactionReason;
import me.mraxetv.beasttokens.api.handlers.BTTokensManager;
import org.bukkit.entity.Player;

// Call from your main-thread listener or scheduled task.
public void reward(Player player) {
    BTTokensManager tokens = BeastTokensAPI.getTokensManager();
    if (tokens.isLoaded(player)) {
        double balance = tokens.getTokens(player);
        tokens.addTokens(player, 100.0, BTTransactionReason.EXTERNAL);
    }
}
```

Use `getTokensManager("Gems")` for a configured currency. The legacy manager lookup falls back to the default wallet for unknown native currency IDs. Validate the configured ID before using it for payments. The reserved ID `Vault` accesses the external shop economy hook rather than a native BeastTokens wallet.

## Check a payment result

For integrations that need an explicit debit or credit outcome, use `getTradingCurrencies()`. Its keys are exact configured currency IDs; an unknown ID is absent and never selects another wallet.

```java
import java.math.BigDecimal;
import java.util.UUID;
import me.mraxetv.beasttokens.api.BeastTokensAPI;
import me.mraxetv.beasttokens.api.handlers.BTBalanceChangeResult;
import me.mraxetv.beasttokens.api.handlers.BTTradingCurrency;
import org.bukkit.entity.Player;

// Call on the main thread with an online player.
public void charge(Player player) {
    BTTradingCurrency currency = BeastTokensAPI.getTradingCurrencies().get("Tokens");
    if (currency != null && currency.isReady(player)) {
        UUID operationId = UUID.randomUUID();
        BTBalanceChangeResult result =
                currency.withdraw(player, new BigDecimal("25"), operationId);

        switch (result.status()) {
            case SUCCESS:
                // The complete immediate wallet change was confirmed.
                break;
            case REJECTED:
                // No mutation was accepted. Inspect result.reason().
                break;
            case UNKNOWN:
                // Record operationId and result for reconciliation.
                // Do not retry or refund an uncertain change blindly.
                break;
        }
    }
}
```

This capability exposes enabled, writable native wallets and reports their precision, maximum balance, display information, and stable wallet identity. Vault and other external economy adapters are outside this map. Calls require the ordinary server thread and loaded, online, writable player data. Check readiness at the point of use; adapters become unavailable when their manager is replaced or BeastTokens disables.

Results describe the immediate in-memory wallet change. They are not durable database receipts or atomic transactions with another plugin. An operation UUID identifies your operation for correlation; it does not provide durable idempotency. Preserve uncertain operations in your integration's journal for reconciliation.

## Events and managers

Start with these API types:

| Area | Types |
| --- | --- |
| Access and currencies | `BeastTokensAPI`, `BTTokensManager`, `BTTradingCurrency` |
| Players and shops | `BTPlayersManager`, `BTShopManager`, `BTPlayer`, `BTShopData` |
| Transaction events | `BTPreTransactionShopEvent`, `BTTransactionBuyEvent`, `BTTransactionSellEvent` |
| Currency context | `BTCurrencyEvent`, `BTTransactionReason` |
| Rewards | `BTokenRedeemEvent`, events under `events.tokendrops` |
| Boosters | `ChanceBoosterManager`, `QuantityBoosterManager` |

See the sources and Javadocs in the release assets for signatures. Currency-aware events expose their currency ID and transaction reason. Buy and sell events also expose per-currency prices and a transaction ID when supplied by the runtime.

## Upgrading from the old 3.x API

Recompile against this release and review your event listeners and wrapper calls before updating a server. The current API follows BeastTokens 4.3.17 and is not a binary compatibility promise for the old 3.15.2 release.

- Shop completion uses `BTTransactionBuyEvent` and `BTTransactionSellEvent`; `BTPostTransactionShopEvent` and `ActionType` are absent from this API.
- Event constructors and several shop, reward, and storage signatures have changed since 3.x. Use the current sources or Javadocs when migrating.
- Prefer `getPlayersManager()` and `getShopManager()`. The old misspelled `getPlayersManger()` and `getShopManger()` aliases remain deprecated.
- Compile against the API version supplied by your target BeastTokens server. New methods require a runtime that provides them.

## Build from source

Use JDK 17 or newer and Maven 3.9 or newer. The published API uses Java 8
bytecode; the Minecraft server and BeastTokens runtime determine your server's
Java requirements.

```shell
git clone https://github.com/MrAxeTv/BeastTokensAPI.git
cd BeastTokensAPI
mvn clean verify
```

To also build source and Javadoc JARs:

```shell
mvn -Prelease clean verify
```

Build output goes to `target/`. The standalone build uses public dependencies and does not install anything onto a Minecraft server. See [the release archive](updates/README.md) for maintainer publishing notes.
