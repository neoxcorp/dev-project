package dev.project.common.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

private val lightScheme =
    lightColors(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        error = errorLight,
        onError = onErrorLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
    )

private val darkScheme =
    darkColors(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        error = errorDark,
        onError = onErrorDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
    )

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color,
)

val unspecified_scheme =
    ColorFamily(
        Color.Unspecified,
        Color.Unspecified,
        Color.Unspecified,
        Color.Unspecified,
    )

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content:
        @Composable()
        () -> Unit,
) {
    val colors = if (darkTheme) darkScheme else lightScheme

    MaterialTheme(
        colors = colors,
        typography = AppTypography,
        content = {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background),
            ) {
                content()
            }
        },
    )
}
