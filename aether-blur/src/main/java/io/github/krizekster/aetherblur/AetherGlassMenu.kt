package io.github.krizekster.aetherblur

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * A glassmorphic container specifically tailored for dropdowns, popups, and context menus.
 *
 * @param modifier Composable modifier for menu positioning and width constraints.
 * @param preset Pre-configured [AetherBlurPreset]. Defaults to [AetherPresets.Obsidian].
 * @param shape Corner curvature of the menu container. Defaults to 16.dp rounded corners.
 * @param contentPadding Inner padding inside the glass container.
 * @param content Vertical list of menu items.
 */
@Composable
fun AetherGlassMenu(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape = RoundedCornerShape(16.dp),
    contentPadding: PaddingValues = PaddingValues(vertical = 8.dp),
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .aetherBlur(preset = preset, shape = shape)
            .padding(contentPadding),
        content = content
    )
}
