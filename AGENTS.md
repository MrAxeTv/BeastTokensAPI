# BeastTokens API agent notes

- Follow the shared Beast project rules in `../AGENTS.md` when working in the owner's Beast workspace.
- This public repository contains only `me.mraxetv.beasttokens.api` sources, developer documentation and API build/release tooling.
- Never copy paid BeastTokens implementation sources, runtime JARs, private Git history, credentials or server files into this repository or its releases.
- Preserve public API packages and Maven coordinates. Keep the standalone POM independent of the private BeastTokens parent.
- This JAR is a provided developer dependency, not a server plugin. Do not add server export tasks or bundle dependencies.
- Run `mvn -Prelease clean verify` and `pwsh -File scripts/Verify-ApiRelease.ps1` before preparing a release.
- Keep complete versioned GitHub notes in `updates/github/BeastTokensAPI-<version>.md`, including the title and purchase links. Preserve older notes and follow `updates/README.md` and the shared release archive convention.
- Archive creation does not authorize publication. Publish only when the owner explicitly requests it.

## When to update GitHub

- Owner-confirmed: maintain this repository as the public developer distribution for BeastTokens. Public API classes, signatures, events, enums or contract changes require synchronized API source and developer documentation during preparation.
- Each requested BeastTokens release/version bump also prepares a matching API version, standalone POM, README examples and `updates/github/BeastTokensAPI-<version>.md`. Compare against the last published API release. If the API code is unchanged, describe version/build alignment without inventing API fixes.
- An authorized request to publish a BeastTokens GitHub release includes the matching API repository update, version tag and GitHub release with verified developer assets. Do not request the same permission again for these included steps. Code changes, local builds, version bumps and draft notes alone prepare the update locally and do not authorize publication.
- Preserve this public repository's ancestry. Synchronize only the public API package from the main project's `btapi` module; never merge, copy or push the private implementation repository's history here.

## Release contents and verification

- Build with `mvn -Prelease clean verify`, then run `scripts/Verify-ApiRelease.ps1` (PowerShell 7: `pwsh -File scripts/Verify-ApiRelease.ps1 -ExpectedVersion <version>`). The script verifies the API boundary and creates checksums.
- Publish only `BeastTokensAPI-<version>.jar`, `BeastTokensAPI-<version>-sources.jar`, `BeastTokensAPI-<version>-javadoc.jar` and `SHA256SUMS`. Review the staged source tree and ancestry before pushing. Never upload paid plugin, proxy, BeastLib or extension JARs.
- Publish a fresh matching version tag, preserve older releases, and use the complete archived Markdown post as the release body. The manually dispatched `Publish API release` workflow accepts an existing version tag and performs build, verification and asset publication.
- Verify the published release is public, its four assets are present, the downloaded hashes match `SHA256SUMS`, and both purchase buttons serve the intended artwork and link to the correct listings. Preserve published tags and binary assets when correcting release text or artwork.

## Purchase button artwork

- Keep two distinct branded buttons in the README and release posts: the SpigotMC tap icon and BuiltByBit's official cube icon. Reuse `.github/assets/get-beasttokens-spigot.svg` and `.github/assets/get-beasttokens-builtbybit.svg`; preserve the source credits in `.github/assets/README.md`. Do not substitute generic letters or coin icons.
- Spigot target: `https://www.spigotmc.org/resources/beasttokens-multishop-mob-and-block-token-drops.20806/`.
- BuiltByBit target: `https://builtbybit.com/resources/beasttokens.28772/`.
- Use meaningful image alt text. Pin release image URLs to the version tag or reviewed artwork commit so older releases retain their artwork.
- For a requested correction after publication, commit the corrected artwork first, then update both the archived post and published release body with URLs pinned to that artwork commit. Do not move the version tag or replace the API binaries for a visual correction. See `updates/README.md`.
