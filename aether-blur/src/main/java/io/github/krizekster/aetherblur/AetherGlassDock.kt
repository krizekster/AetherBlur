package io.github.krizekster.aetherblur

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * A floating, glassmorphic navigation dock / segmented toolbar pill.
 *
 * Designed for bottom navigation bars, quick-action islands, and media controls.
 *
 * @param modifier Composable modifier for positioning and sizing.
 * @param preset Pre-configured [AetherBlurPreset]. Defaults to [AetherPresets.Obsidian].
 * @param shape Pill shape geometry. Defaults to [CircleShape].
 * @param horizontalArrangement Horizontal arrangement for child items.
 * @param verticalAlignment Vertical alignment for child items.
 * @param contentPadding Inner padding inside the glass capsule.
 * @param content Composable slot for dock items (icons, buttons, indicators).
 */
@Composable
fun AetherGlassDock(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape = CircleShape,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .aetherBlur(preset = preset, shape = shape)
            .padding(contentPadding),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment,
        content = content
    )
}
