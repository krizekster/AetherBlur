# AetherBlur — Publishing & Distribution Guide

This guide covers how to distribute **AetherBlur** via JitPack and Maven Central, as well as how to integrate it as a local git submodule or pre-compiled AAR.

---

## 1. JitPack Distribution (Recommended for Immediate Release)

JitPack builds Android libraries directly from GitHub releases without manual signing ceremonies.

### Step 1: Push Tag to GitHub
```bash
git tag -a v1.0.0 -m "Release v1.0.0: Initial public release of AetherBlur"
git push origin v1.0.0
```

### Step 2: Configure jitpack.yml (Included)
The repository includes `.jitpack.yml` specifying:
```yaml
jdk:
  - openjdk17
install:
  - ./gradlew :aether-blur:publishToMavenLocal
```

### Step 3: Consumer Integration
Users add JitPack to their repository list:
```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Then add the dependency:
```kotlin
// app/build.gradle.kts
dependencies {
    implementation("com.github.krizekster:AetherBlur:1.0.0")
}
```

---

## 2. Maven Central Distribution

The `:aether-blur` module is pre-configured with the standard `maven-publish` plugin and POM metadata (developer info, MIT license, SCM links).

To publish to Sonatype Maven Central:
1. Generate GPG signing keys.
2. Configure credentials in `gradle.properties` or environment variables (`OSSRH_USERNAME`, `OSSRH_PASSWORD`).
3. Run `publishReleasePublicationToSonatypeRepository`.

---

## 3. Local Project Submodule Integration

To include AetherBlur directly in your workspace (such as in `CodenameKratos`):

```kotlin
// In your app's settings.gradle.kts:
includeBuild("../AetherBlur")

// In your feature/core module build.gradle.kts:
dependencies {
    implementation("io.github.krizekster:aether-blur:1.0.0")
}
```
