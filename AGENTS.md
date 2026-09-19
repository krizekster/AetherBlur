# AGENTS.md — Universal Agent Instructions & Project Context

## Project Overview: AetherBlur

AetherBlur is a high-performance, hardware-accelerated blur and glassmorphism framework for Native Android (Jetpack Compose). Engineered for 120Hz high-refresh mobile displays with chained `RenderEffect` pipelines, `ColorMatrix` saturation boost, directional specular rim reflections, and OLED anti-banding dithering.

* **GitHub Repository:** `https://github.com/krizekster/AetherBlur`
* **Package / Maven ID:** `io.github.krizekster:aether-blur:1.0.0`
* **Architecture:** Multi-module Gradle (`:aether-blur` library and `:sample` catalog app)
* **Tech Stack:** Kotlin 2.1.0, Jetpack Compose, Material 3, Android 12+ (API 31+) RenderEffect with graceful pre-API 31 acrylic fallback.

---

## Developer Identity

| Field         | Value                                      |
|---------------|--------------------------------------------|
| **Name**      | Krishna Soni                               |
| **Email**     | krizekster@gmail.com                       |
| **GitHub**    | [@krizekster](https://github.com/krizekster) |
| **Git Email** | krizekster@gmail.com (set globally)        |

---

## Non-Negotiable Operational Rules

1. **NO Gradle / Build Execution:** Never execute `gradlew`, `gradlew.bat`, compilation tasks (`compileDebugKotlin`, `assembleRelease`), unit test runners, or start background Gradle daemons. All compilation and builds are managed by the developer in Android Studio.
2. **Commit Authorization:** Ask before running git commits or git pushes unless explicitly directed by the user.
3. **Library Purity:** The `:aether-blur` library module must remain zero-dependency outside of core Jetpack Compose UI foundations.
4. **Documentation Structure Compliance:** In-depth documentation belongs in [`docs/`]. Root markdown files are reserved for [`README.md`](README.md), [`CHANGELOG.md`](CHANGELOG.md), [`AGENTS.md`](AGENTS.md), and [`GEMINI.md`](GEMINI.md).
