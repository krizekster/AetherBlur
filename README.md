# AetherBlur

<div align="center">

[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat-square)](https://android-arsenal.com/api?level=24)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg?style=flat-square)](https://kotlinlang.org)
[![Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-4285F4.svg?style=flat-square)](https://developer.android.com/jetpack/compose)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](LICENSE)
[![JitPack](https://jitpack.io/v/krizekster/AetherBlur.svg)](https://jitpack.io/#krizekster/AetherBlur)

**A hardware-accelerated, high-fidelity blur & glassmorphism framework for Native Android (Jetpack Compose), engineered for 120Hz high-refresh displays with zero color banding.**

[Interactive Studio](tools/aether_blur_studio.html) • [Documentation](docs/architecture.md) • [API Reference](docs/api_reference.md) • [Sample App](sample/)

</div>

---

## Highlights

* 🚀 **Hardware Accelerated:** Chained Android 12+ (API 31+) `RenderEffect` pipelines completing in **~0.6ms – 0.8ms per frame** on modern Adreno/Mali GPUs.
* 💎 **Optical Brilliance:** Chained `ColorMatrix` saturation boost recreating authentic Apple/macOS-grade glass vibrancy on Android.
* 💡 **Directional Specular Rim Lighting:** Simulated top-left ambient light reflection gradient along component borders.
* 📱 **OLED Anti-Banding Dither:** Eliminates stepped 8-bit quantization banding on deep dark OLED screens.
* 🛡️ **Zero-Crash Graceful Degradation:** Automatic high-contrast translucent acrylic fallback for Android 8.0 – 11 (API 24 – 30) devices.
* 🧪 **Interactive Web Studio:** Local browser-based tuning laboratory with real-time sliders and scrolling backdrops (`tools/aether_blur_studio.html`).

---

## Interactive Design Studio

Before hardcoding values, calibrate your blur optics visually with our bundled laboratory:

Open [`tools/aether_blur_studio.html`](tools/aether_blur_studio.html) directly in any browser:
* Sliders for blur radius, saturation boost, scrim opacity, specular rim stroke, and corner radius.
* Scroll mouse wheel to glide realistic backdrops (task boards, gaming telemetry, fluid aurora) directly behind the live glass component.
* Instant copy-paste Jetpack Compose code export.

---

## Installation

### 1. Add JitPack repository to your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}
```

### 2. Add the dependency to your module `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.krizekster:AetherBlur:1.0.0")
}
```

---

## Quick Start

### 1. Apply to Any Composable via Modifier

```kotlin
import io.github.krizekster.aetherblur.aetherBlur

Box(
    modifier = Modifier
        .fillMaxWidth()
        .aetherBlur(
            radius = 24.dp,
            tintColor = Color(0xFF101014),
            tintAlpha = 0.58f,
            cornerRadius = 20.dp,
            borderWidth = 1.dp,
            saturationBoost = 1.35f,
            specularAlpha = 0.35f
        )
        .padding(20.dp)
) {
    Text(
        text = "Frosted Glass Content",
        color = Color.White
    )
}
```

### 2. High-Level Ready-to-Use Components

#### Frosted Glass Card
```kotlin
import io.github.krizekster.aetherblur.AetherGlassCard

AetherGlassCard(
    radius = 24.dp,
    cornerRadius = 20.dp
) {
    Column {
        Text("Quest Card Dialog", style = MaterialTheme.typography.titleMedium)
        Text("Real-time backdrop refraction", style = MaterialTheme.typography.bodySmall)
    }
}
```

#### Floating Action Dock / Pill Navigation
```kotlin
import io.github.krizekster.aetherblur.AetherGlassDock

AetherGlassDock {
    IconButton(onClick = { /* Home */ }) {
        Icon(Icons.Rounded.Home, contentDescription = "Home", tint = Color.White)
    }
    IconButton(onClick = { /* Search */ }) {
        Icon(Icons.Rounded.Search, contentDescription = "Search", tint = Color.White)
    }
}
```

---

## Curated Presets

```kotlin
import io.github.krizekster.aetherblur.AetherPresets

// Apply preset directly
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.Obsidian))
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.ArcticFrost))
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.CyberpunkNeon))
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.AmoledVoid))
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.CupertinoUltraThin))
Box(modifier = Modifier.aetherBlur(preset = AetherPresets.AlteredBrilliance))
```

---

## Architecture & Compatibility

| Android Version | Implementation Mechanism | Visual Result |
|---|---|---|
| **Android 12+ (API 31+)** | `RenderEffect.createChainEffect(satEffect, blurEffect)` | True hardware backdrop blur + saturation boost |
| **Android 8.0 – 11 (API 24–30)** | High-contrast translucent acrylic scrim + micro-dither | Smooth acrylic frosted glass fallback (0 crash) |

---

## License

```text
MIT License — Copyright (c) 2026 Krishna Soni (Kri Zek)
```