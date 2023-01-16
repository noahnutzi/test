package com.example.easyprint.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = Black,
    surface = GreyDark,
    onSurface = White,
    primary = BlueGreyDark,
    onPrimary = White,
    secondary = Black,
)

private val LightColorPalette = lightColors(
    background = BlueGreyBright,
    surface = White,
    onSurface = Black,
    primary = BlueGreyDark,
    onPrimary = White,
    secondary = Black,
)


@Composable
fun EasyPrintTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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