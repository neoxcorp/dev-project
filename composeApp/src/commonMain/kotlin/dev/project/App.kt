package dev.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import dev.project.di.initKoin
import dev.project.splash.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {
    // todo move it because of KoinApplicationAlreadyStartedException:
    // todo: A Koin Application has already been started
    initKoin()

    val greeting = koinInject<Greeting>()

    MaterialTheme {
        Navigator(screen = SplashScreen()) { content ->
            SlideTransition(content)
        }
    }
}
