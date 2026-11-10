# BeastTokens API agent notes

- Follow the shared Beast project rules in `../AGENTS.md` when working in the owner's Beast workspace.
- This public repository contains only `me.mraxetv.beasttokens.api` sources, developer documentation and API build/release tooling.
- Never copy paid BeastTokens implementation sources, runtime JARs, private Git history, credentials or server files into this repository or its releases.
- Preserve public API packages and Maven coordinates. Keep the standalone POM independent of the private BeastTokens parent.
- This JAR is a provided developer dependency, not a server plugin. Do not add server export tasks or bundle dependencies.
- Run `mvn -Prelease clean verify` and `pwsh -File scripts/Verify-ApiRelease.ps1` before preparing a release.
- Keep complete versioned GitHub notes in `updates/github/BeastTokensAPI-<version>.md`, including the title and purchase links. Preserve older notes and follow `updates/README.md` and the shared release archive convention.
- Archive creation does not authorize publication. Publish only when the owner explicitly requests it.
