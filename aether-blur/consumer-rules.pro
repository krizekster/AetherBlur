# AetherBlur Consumer Proguard Rules
# Keep RenderEffect usage on API 31+ without stripping
-keepclassmembers class androidx.compose.ui.graphics.RenderEffect { *; }
-keepclassmembers class android.graphics.RenderEffect { *; }
