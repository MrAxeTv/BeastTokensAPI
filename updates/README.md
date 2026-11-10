# API release archive

Keep complete GitHub release posts in `github/BeastTokensAPI-<version>.md`, including a versioned title. Preserve previous releases; create a new file for the next version.

Each post starts with the two purchase badges linking to the main BeastTokens plugin. Use badge image URLs pinned to that release's tag so older releases keep their original artwork. Describe API changes, migration requirements, and build or documentation updates. Main-plugin runtime changes belong in that product's release notes.

For a requested artwork correction after publication, pin the replacement images to the reviewed artwork commit and update the archived post and published release body together. Preserve the version tag and release binaries.

Build the API and its source/Javadoc assets with `mvn -Prelease clean verify`. Publish only the API binary, source JAR, Javadoc JAR, and `SHA256SUMS` checksums. The API JAR is a developer dependency; it is not a server plugin. Keep this archive and badge sources outside the JARs.

The versioned Markdown post is the source for the GitHub release body. Creating or editing a local post does not publish it. Publish only when the owner requests a release.
