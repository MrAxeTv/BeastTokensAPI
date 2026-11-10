param(
    [string]$ExpectedVersion
)

$ErrorActionPreference = 'Stop'
$repositoryRoot = [IO.Path]::GetFullPath((Join-Path $PSScriptRoot '..'))
[xml]$pom = Get-Content -LiteralPath (Join-Path $repositoryRoot 'pom.xml') -Raw
$version = [string]$pom.project.version
if ($ExpectedVersion -and $ExpectedVersion -cne $version) {
    throw "Release version '$ExpectedVersion' does not match POM version '$version'."
}
if ($version -notmatch '^\d+\.\d+\.\d+$') {
    throw 'Release version must be a numeric major.minor.patch version.'
}
if ($pom.project.parent -or $pom.project.modules) {
    throw 'The public API must have a standalone POM without a private parent or modules.'
}

$sourceRoot = Join-Path $repositoryRoot 'src/main/java'
$sourceFiles = @(Get-ChildItem -LiteralPath $sourceRoot -Recurse -File)
if ($sourceFiles.Count -eq 0) { throw 'No API sources found.' }
foreach ($file in $sourceFiles) {
    $relative = $file.FullName.Substring($sourceRoot.Length + 1).Replace('\', '/')
    if ($relative -notmatch '^me/mraxetv/beasttokens/api/.+\.java$') {
        throw "Unexpected public source: $relative"
    }
    $content = Get-Content -LiteralPath $file.FullName -Raw
    if ($content -notmatch '(?m)^package me\.mraxetv\.beasttokens\.api(?:\.[\w.]+)?;') {
        throw "Source outside the API package: $relative"
    }
    if ($content -match '(?m)^import (?:static )?me\.mraxetv\.(?:beasttokens\.(?!api\.)|beastlib\.)') {
        throw "Private implementation import in $relative"
    }
}

Add-Type -AssemblyName System.IO.Compression.FileSystem
$buildDirectory = Join-Path $repositoryRoot 'target'
$baseName = "BeastTokensAPI-$version"
$assets = @("$baseName.jar", "$baseName-sources.jar", "$baseName-javadoc.jar")
foreach ($asset in $assets) {
    $assetPath = Join-Path $buildDirectory $asset
    if (-not (Test-Path -LiteralPath $assetPath -PathType Leaf)) {
        throw "Missing release asset: $asset"
    }
    $archive = [IO.Compression.ZipFile]::OpenRead($assetPath)
    try {
        foreach ($entry in $archive.Entries) {
            $name = $entry.FullName
            if ($name.EndsWith('/')) { continue }
            if ($asset -eq "$baseName.jar") {
                if ($name -notmatch '^(?:META-INF/MANIFEST\.MF$|META-INF/maven/me\.mraxetv\.beasttokens/btapi/pom\.(?:xml|properties)$|me/mraxetv/beasttokens/api/.+\.class$)') {
                    throw "Unexpected binary entry in ${asset}: $name"
                }
            } elseif ($asset -eq "$baseName-sources.jar") {
                if ($name -notmatch '^(?:META-INF/MANIFEST\.MF$|META-INF/maven/me\.mraxetv\.beasttokens/btapi/pom\.(?:xml|properties)$|me/mraxetv/beasttokens/api/.+\.java$)') {
                    throw "Unexpected source entry in ${asset}: $name"
                }
            } elseif ($name -match '\.(?:class|java)$|(?:^|/)plugin\.yml$') {
                throw "Unexpected source or binary in Javadoc: $name"
            }
        }
        if ($asset -eq "$baseName.jar") {
            $apiClass = $archive.GetEntry('me/mraxetv/beasttokens/api/BeastTokensAPI.class')
            if (-not $apiClass) { throw 'Missing BeastTokensAPI entry point.' }
            $stream = $apiClass.Open()
            try {
                $header = New-Object byte[] 8
                if ($stream.Read($header, 0, 8) -ne 8) { throw 'Incomplete class header.' }
                $major = ([int]$header[6] * 256) + [int]$header[7]
                if ($major -ne 52) { throw "Expected Java 8 bytecode (52), found $major." }
            } finally { $stream.Dispose() }
        }
    } finally { $archive.Dispose() }
}

$checksums = foreach ($asset in $assets) {
    $hash = (Get-FileHash -LiteralPath (Join-Path $buildDirectory $asset) -Algorithm SHA256).Hash.ToLowerInvariant()
    "$hash  $asset"
}
[IO.File]::WriteAllText((Join-Path $buildDirectory 'SHA256SUMS'), ($checksums -join "`n") + "`n", (New-Object Text.UTF8Encoding $false))
Write-Host "Verified $($sourceFiles.Count) API sources, Java 8 binary, sources and Javadoc for $version."
Write-Host 'Created target/SHA256SUMS for the three explicit API release assets.'
