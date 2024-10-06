package dev.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dev.project.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun AppComponents() {
    val greeting = koinInject<Greeting>()
    greeting.log()
    MaterialTheme {
        Navigator(screen = SplashScreen()) { content ->
            SlideTransition(content)
        }
    }
}
