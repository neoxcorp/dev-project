package dev.project.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.project.news.NewsScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        SplashScreenComponents()
    }
}

@Composable
@Preview
fun SplashScreenComponents() {
    val navigator = LocalNavigator.currentOrThrow
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = { navigator.replace(NewsScreen()) },
        ) {
            Text("Splash!")
        }
    }
}
