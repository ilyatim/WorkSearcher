package com.example.composeworksearcher.ui.theme

import android.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = dark_primary,
    primaryVariant = dark_primary_variant,
    secondary = dark_secondary,
    onPrimary = dark_onPrimary,
    secondaryVariant = dark_secondary_variant,
    onSurface = dark_onSurface,
    onSecondary = dark_onSecondary,
    onError = dark_onError,
    onBackground = dark_onBackground,
    background = dark_background,
    error = dark_error,
    surface = dark_surface
)

private val LightColorPalette = lightColors(
    primary = light_primary,
    primaryVariant = light_primary_variant,
    secondary = light_secondary,
    onPrimary = light_onPrimary,
    surface = light_surface,
    error = light_error,
    background = light_background,
    onBackground = light_onBackground,
    onError = light_onError,
    onSecondary = light_onSecondary,
    onSurface = light_onSurface,
    secondaryVariant = light_secondary_variant,
)

@Composable
fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}