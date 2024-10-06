package dev.project

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dev.project.common.theme.AppTheme
import dev.project.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppComponents() {
    AppTheme {
        Navigator(screen = SplashScreen()) { content ->
            SlideTransition(content)
        }
    }
}
