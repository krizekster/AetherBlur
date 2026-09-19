package io.github.krizekster.aetherblur

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A ready-to-use glassmorphic card container utilizing [Modifier.aetherBlur].
 *
 * Perfect for modals, dashboard widgets, telemetry cards, and dialogs.
 *
 * @param modifier Composable modifier for sizing and placement.
 * @param preset Pre-configured [AetherBlurPreset]. Defaults to [AetherPresets.Obsidian].
 * @param shape Optional custom [Shape] overriding the preset's corner curvature.
 * @param contentPadding Internal padding applied around the card's content.
 * @param content Slot for the card's child composables.
 */
@Composable
fun AetherGlassCard(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape? = null,
    contentPadding: PaddingValues = PaddingValues(20.dp),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .aetherBlur(preset = preset, shape = shape)
            .padding(contentPadding),
        content = content
    )
}

/**
 * Overload for [AetherGlassCard] with granular optical customization.
 */
@Composable
fun AetherGlassCard(
    modifier: Modifier = Modifier,
    radius: Dp = 24.dp,
    tintColor: Color = Color(0xFF101014),
    tintAlpha: Float = 0.58f,
    cornerRadius: Dp = 20.dp,
    borderWidth: Dp = 1.dp,
    saturationBoost: Float = 1.35f,
    specularAlpha: Float = 0.35f,
    shape: Shape? = null,
    contentPadding: PaddingValues = PaddingValues(20.dp),
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .aetherBlur(
                radius = radius,
                tintColor = tintColor,
                tintAlpha = tintAlpha,
                cornerRadius = cornerRadius,
                borderWidth = borderWidth,
                saturationBoost = saturationBoost,
                specularAlpha = specularAlpha,
                shape = shape
            )
            .padding(contentPadding),
        content = content
    )
}
