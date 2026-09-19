# AetherBlur — API Reference

Comprehensive reference for the AetherBlur Kotlin Jetpack Compose library.

---

## 1. `Modifier.aetherBlur`

The foundational modifier for applying hardware-accelerated glassmorphism to any Composable.

```kotlin
@Composable
fun Modifier.aetherBlur(
    radius: Dp = 24.dp,
    tintColor: Color = Color(0xFF101014),
    tintAlpha: Float = 0.58f,
    cornerRadius: Dp = 20.dp,
    borderWidth: Dp = 1.dp,
    saturationBoost: Float = 1.35f,
    specularAlpha: Float = 0.35f,
    shape: Shape? = null
): Modifier
```

### Parameters

| Parameter | Type | Default | Description |
|---|---|---|---|
| `radius` | `Dp` | `24.dp` | Gaussian blur dispersion radius. |
| `tintColor` | `Color` | `0xFF101014` | Base color overlay for the glass scrim. |
| `tintAlpha` | `Float` | `0.58f` | Opacity of the base tint color (0.0f – 1.0f). |
| `cornerRadius` | `Dp` | `20.dp` | Corner curvature of the clipped glass boundary. |
| `borderWidth` | `Dp` | `1.dp` | Thickness of the directional specular highlight rim. |
| `saturationBoost` | `Float` | `1.35f` | Multiplier for backdrop color saturation through glass. |
| `specularAlpha` | `Float` | `0.35f` | Top-left specular highlight reflection intensity. |
| `shape` | `Shape?` | `null` | Optional custom shape overriding `cornerRadius`. |

### Preset Overload

```kotlin
@Composable
fun Modifier.aetherBlur(
    preset: AetherBlurPreset,
    shape: Shape? = null
): Modifier
```

---

## 2. `AetherPresets`

Pre-configured, production-tested optical recipes:

```kotlin
object AetherPresets {
    val Obsidian: AetherBlurPreset         // Deep void dark theme (Refinite standard)
    val ArcticFrost: AetherBlurPreset      // Clean, bright frosted glass for light themes
    val CyberpunkNeon: AetherBlurPreset    // High-saturation neon luminescence
    val AmoledVoid: AetherBlurPreset       // True pitch-black OLED power saver
    val CupertinoUltraThin: AetherBlurPreset // Airy high-refraction frosted acrylic
    val AlteredBrilliance: AetherBlurPreset // Barely-there translucent HUD overlay
    val all: List<AetherBlurPreset>       // All presets for gallery iterations
}
```

---

## 3. High-Level Composable Components

### `AetherGlassCard`
A ready-to-use glassmorphic card container.

```kotlin
@Composable
fun AetherGlassCard(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape? = null,
    contentPadding: PaddingValues = PaddingValues(20.dp),
    content: @Composable BoxScope.() -> Unit
)
```

### `AetherGlassDock`
A floating navigation bar or quick-action toolbar capsule.

```kotlin
@Composable
fun AetherGlassDock(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape = CircleShape,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    content: @Composable RowScope.() -> Unit
)
```

### `AetherGlassMenu`
A glassmorphic container for dropdown menus and context sheets.

```kotlin
@Composable
fun AetherGlassMenu(
    modifier: Modifier = Modifier,
    preset: AetherBlurPreset = AetherPresets.Obsidian,
    shape: Shape = RoundedCornerShape(16.dp),
    contentPadding: PaddingValues = PaddingValues(vertical = 8.dp),
    content: @Composable ColumnScope.() -> Unit
)
```
