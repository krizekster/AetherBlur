package io.github.krizekster.aetherblur

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Encapsulates the optical and dimensional parameters for an [AetherBlur] material.
 *
 * @property name Human-readable name of the preset.
 * @property radius Gaussian blur dispersion radius in Dp.
 * @property tintColor Base tint color overlaid across the blurred backdrop.
 * @property tintAlpha Opacity level of the tint color (0.0f - 1.0f).
 * @property cornerRadius Default corner curvature applied to the glass geometry.
 * @property borderWidth Specular rim highlight border thickness.
 * @property saturationBoost Backdrop color saturation boost factor (1.0 = neutral, >1.0 = hyper-vibrant).
 * @property specularAlpha Ambient rim highlight reflection intensity (0.0f - 1.0f).
 */
@Immutable
data class AetherBlurPreset(
    val name: String,
    val radius: Dp = 24.dp,
    val tintColor: Color = Color(0xFF101014),
    val tintAlpha: Float = 0.58f,
    val cornerRadius: Dp = 20.dp,
    val borderWidth: Dp = 1.dp,
    val saturationBoost: Float = 1.35f,
    val specularAlpha: Float = 0.35f
)

/**
 * Curated, production-calibrated presets tuned for 120Hz mobile OLED/AMOLED displays.
 */
object AetherPresets {

    /**
     * Deep void luxury obsidian aesthetic. Ideal for dark-themed command centers,
     * high-contrast dashboards, and HUD cards.
     */
    val Obsidian = AetherBlurPreset(
        name = "Obsidian",
        radius = 24.dp,
        tintColor = Color(0xFF101014),
        tintAlpha = 0.58f,
        cornerRadius = 20.dp,
        borderWidth = 1.dp,
        saturationBoost = 1.35f,
        specularAlpha = 0.35f
    )

    /**
     * Clean, bright, high-contrast frosted glass surface. Ideal for light themes,
     * dialog sheets, and subtle modal surfaces.
     */
    val ArcticFrost = AetherBlurPreset(
        name = "Arctic Frost",
        radius = 32.dp,
        tintColor = Color(0xFFFFFFFF),
        tintAlpha = 0.35f,
        cornerRadius = 24.dp,
        borderWidth = 1.5.dp,
        saturationBoost = 1.10f,
        specularAlpha = 0.70f
    )

    /**
     * High-energy neon luminescence tuned for gaming telemetry, cybernetic HUDs,
     * and active weapon/stat overlays.
     */
    val CyberpunkNeon = AetherBlurPreset(
        name = "Cyberpunk Neon Rim",
        radius = 28.dp,
        tintColor = Color(0xFF0C1824),
        tintAlpha = 0.66f,
        cornerRadius = 16.dp,
        borderWidth = 1.5.dp,
        saturationBoost = 1.80f,
        specularAlpha = 0.60f
    )

    /**
     * True pitch-black OLED background with zero battery waste on unlit sub-pixels.
     * Retains subtle specular edge refraction.
     */
    val AmoledVoid = AetherBlurPreset(
        name = "AMOLED Void Black",
        radius = 18.dp,
        tintColor = Color(0xFF09090C),
        tintAlpha = 0.82f,
        cornerRadius = 20.dp,
        borderWidth = 0.75.dp,
        saturationBoost = 1.15f,
        specularAlpha = 0.20f
    )

    /**
     * High-refraction, ultra-thin frosted acrylic inspired by modern desktop and
     * mobile glass materials.
     */
    val CupertinoUltraThin = AetherBlurPreset(
        name = "Cupertino Ultra-Thin",
        radius = 40.dp,
        tintColor = Color(0xFF18181B),
        tintAlpha = 0.45f,
        cornerRadius = 28.dp,
        borderWidth = 0.5.dp,
        saturationBoost = 1.60f,
        specularAlpha = 0.50f
    )

    /**
     * Barely-there translucent HUD overlay engineered for real-time gaming
     * overlays and telemetry gauges.
     */
    val AlteredBrilliance = AetherBlurPreset(
        name = "Altered Brilliance HUD",
        radius = 14.dp,
        tintColor = Color(0xFF080C10),
        tintAlpha = 0.40f,
        cornerRadius = 12.dp,
        borderWidth = 1.dp,
        saturationBoost = 1.05f,
        specularAlpha = 0.45f
    )

    /**
     * List of all curated presets for easy gallery cycling.
     */
    val all: List<AetherBlurPreset> = listOf(
        Obsidian,
        ArcticFrost,
        CyberpunkNeon,
        AmoledVoid,
        CupertinoUltraThin,
        AlteredBrilliance
    )
}
