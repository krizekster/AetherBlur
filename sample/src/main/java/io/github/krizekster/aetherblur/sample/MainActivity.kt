package io.github.krizekster.aetherblur.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.krizekster.aetherblur.AetherBlurPreset
import io.github.krizekster.aetherblur.AetherGlassCard
import io.github.krizekster.aetherblur.AetherGlassDock
import io.github.krizekster.aetherblur.AetherGlassMenu
import io.github.krizekster.aetherblur.AetherPresets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF070709)
                ) {
                    AetherBlurShowcaseScreen()
                }
            }
        }
    }
}

enum class SpecimenMode {
    MODAL_CARD,
    FLOATING_DOCK,
    CONTEXT_MENU
}

@Composable
fun AetherBlurShowcaseScreen() {
    var selectedPreset by remember { mutableStateOf(AetherPresets.Obsidian) }
    var blurRadius by remember { mutableFloatStateOf(selectedPreset.radius.value) }
    var saturationBoost by remember { mutableFloatStateOf(selectedPreset.saturationBoost) }
    var tintAlpha by remember { mutableFloatStateOf(selectedPreset.tintAlpha) }
    var specularAlpha by remember { mutableFloatStateOf(selectedPreset.specularAlpha) }
    var activeSpecimen by remember { mutableStateOf(SpecimenMode.MODAL_CARD) }
    var showControls by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        // 1. Scrollable Vibrant Multi-Layer Backdrop
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 80.dp, bottom = 140.dp)
        ) {
            item {
                ShowcaseHeader()
                Spacer(modifier = Modifier.height(24.dp))
            }

            // High-contrast colorful cards to visually test refraction & blur depth
            items(12) { index ->
                BackdropDataCard(index = index)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // 2. Interactive Floating Specimen centered or docked
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 80.dp),
            contentAlignment = when (activeSpecimen) {
                SpecimenMode.MODAL_CARD -> Alignment.Center
                SpecimenMode.FLOATING_DOCK -> Alignment.BottomCenter
                SpecimenMode.CONTEXT_MENU -> Alignment.Center
            }
        ) {
            when (activeSpecimen) {
                SpecimenMode.MODAL_CARD -> {
                    AetherGlassCard(
                        modifier = Modifier.fillMaxWidth(),
                        radius = blurRadius.dp,
                        tintColor = selectedPreset.tintColor,
                        tintAlpha = tintAlpha,
                        cornerRadius = selectedPreset.cornerRadius,
                        borderWidth = selectedPreset.borderWidth,
                        saturationBoost = saturationBoost,
                        specularAlpha = specularAlpha
                    ) {
                        Column {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF6366F1).copy(alpha = 0.25f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.AutoAwesome,
                                            contentDescription = null,
                                            tint = Color(0xFFA5B4FC),
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Column {
                                        Text(
                                            text = "AetherGlass Material",
                                            color = Color.White,
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Hardware RenderEffect • ${blurRadius.toInt()}dp",
                                            color = Color(0xFF94A3B8),
                                            fontSize = 12.sp
                                        )
                                    }
                                }

                                Text(
                                    text = "${selectedPreset.name}",
                                    color = Color(0xFF38BDF8),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "High-precision backdrop blur with ColorMatrix saturation boost chained for 120Hz smooth scrolling. Try scrolling the background behind this card!",
                                color = Color(0xFFCBD5E1),
                                fontSize = 13.sp,
                                lineHeight = 19.sp
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                ElevatedButton(
                                    onClick = { },
                                    colors = ButtonDefaults.elevatedButtonColors(
                                        containerColor = Color(0xFF6366F1),
                                        contentColor = Color.White
                                    ),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text("Engage System", fontSize = 13.sp)
                                }
                            }
                        }
                    }
                }

                SpecimenMode.FLOATING_DOCK -> {
                    AetherGlassDock(
                        modifier = Modifier.padding(bottom = 20.dp),
                        preset = selectedPreset.copy(
                            radius = blurRadius.dp,
                            saturationBoost = saturationBoost,
                            tintAlpha = tintAlpha,
                            specularAlpha = specularAlpha
                        )
                    ) {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Layers, contentDescription = null, tint = Color(0xFF38BDF8))
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Tune, contentDescription = null, tint = Color.White)
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color(0xFF10B981))
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Code, contentDescription = null, tint = Color(0xFFA855F7))
                        }
                    }
                }

                SpecimenMode.CONTEXT_MENU -> {
                    AetherGlassMenu(
                        modifier = Modifier.width(260.dp),
                        preset = selectedPreset.copy(
                            radius = blurRadius.dp,
                            saturationBoost = saturationBoost,
                            tintAlpha = tintAlpha,
                            specularAlpha = specularAlpha
                        )
                    ) {
                        ContextMenuItem("Calibrate Optical Radius", "⌘R")
                        ContextMenuItem("Boost Color Saturation", "⌘S")
                        ContextMenuItem("Toggle OLED Micro-Grain", "⌘N")
                        ContextMenuItem("Copy Jetpack Modifier", "⌘C")
                    }
                }
            }
        }

        // 3. Top Floating Preset & Control Bar
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(Color(0xE60A0A0E))
                .padding(top = 40.dp, bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "AetherBlur Studio",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

                Row {
                    FilterChip(
                        selected = activeSpecimen == SpecimenMode.MODAL_CARD,
                        onClick = { activeSpecimen = SpecimenMode.MODAL_CARD },
                        label = { Text("Card", fontSize = 11.sp) }
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    FilterChip(
                        selected = activeSpecimen == SpecimenMode.FLOATING_DOCK,
                        onClick = { activeSpecimen = SpecimenMode.FLOATING_DOCK },
                        label = { Text("Dock", fontSize = 11.sp) }
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    FilterChip(
                        selected = activeSpecimen == SpecimenMode.CONTEXT_MENU,
                        onClick = { activeSpecimen = SpecimenMode.CONTEXT_MENU },
                        label = { Text("Menu", fontSize = 11.sp) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Preset Selector Chips
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(AetherPresets.all) { preset ->
                    FilterChip(
                        selected = selectedPreset.name == preset.name,
                        onClick = {
                            selectedPreset = preset
                            blurRadius = preset.radius.value
                            saturationBoost = preset.saturationBoost
                            tintAlpha = preset.tintAlpha
                            specularAlpha = preset.specularAlpha
                        },
                        label = { Text(preset.name, fontSize = 12.sp) },
                        leadingIcon = if (selectedPreset.name == preset.name) {
                            { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(14.dp)) }
                        } else null,
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF6366F1).copy(alpha = 0.35f),
                            selectedLabelColor = Color.White,
                            containerColor = Color(0xFF1E1E26),
                            labelColor = Color(0xFF94A3B8)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ContextMenuItem(title: String, shortcut: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, color = Color.White, fontSize = 13.sp)
        Text(
            text = shortcut,
            color = Color(0xFF64748B),
            fontSize = 11.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
fun ShowcaseHeader() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "LIVE BACKDROP TEST BED",
            color = Color(0xFF6366F1),
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.5.sp
        )
        Text(
            text = "Hardware-Accelerated 120Hz Blur",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Scroll the content behind the glass to verify optical clarity, zero color banding, and fluid frame pacing.",
            color = Color(0xFF94A3B8),
            fontSize = 13.sp,
            lineHeight = 18.sp
        )
    }
}

@Composable
fun BackdropDataCard(index: Int) {
    val gradients = listOf(
        listOf(Color(0xFF6366F1), Color(0xFFA855F7), Color(0xFFEC4899)),
        listOf(Color(0xFF06B6D4), Color(0xFF3B82F6), Color(0xFF6366F1)),
        listOf(Color(0xFF10B981), Color(0xFF06B6D4), Color(0xFF3B82F6)),
        listOf(Color(0xFFF59E0B), Color(0xFFEF4444), Color(0xFFEC4899))
    )
    val gradient = gradients[index % gradients.size]

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Brush.horizontalGradient(gradient))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "SECTOR #0${index + 1} TELEMETRY",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "+${(index + 1) * 850} XP",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Target Synchronization Protocol Active",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Dynamic fluid gradient backdrop for real-time optical refraction testing.",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 12.sp
            )
        }
    }
}
