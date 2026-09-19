# Changelog

All notable changes to **AetherBlur** will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.0] - 2026-09-19

### Added
- **Core Modifier:** `Modifier.aetherBlur(...)` with hardware-accelerated `RenderEffect` backdrop blur pipeline for Android 12+ (API 31+).
- **Saturation Boost:** Injected `ColorMatrix` color filter chained into blur pipeline for authentic optical glass refraction.
- **Directional Bevel:** Top-left to bottom-right specular rim lighting gradient brush.
- **OLED Dither Overlay:** Micro-grain dither overlay to prevent 8-bit color banding on dark OLED displays.
- **Pre-API 31 Fallback:** Graceful high-contrast acrylic fallback ensuring zero crashes on Android 8.0 - 11 devices.
- **Ready Components:** `AetherGlassCard` and `AetherGlassDock` (capsule pill action bar).
- **Curated Presets:** `RefiniteObsidian`, `ArcticFrost`, `CyberpunkNeon`, `AmoledVoid`, `CupertinoLiquid`, `AlteredHud`.
- **Interactive Laboratory:** Standalone browser-based studio (`tools/aether_blur_studio.html`) with live optical sliders, 2500px scrollable backdrops, auto-scrolling, and real-time Kotlin code export.
- **Sample Catalog App:** Multi-module showcase application (`:sample`).
